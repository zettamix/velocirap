package slackConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import HTTPClient.*;
import java.net.URL;
import java.net.HttpURLConnection;


public class getToken {
	
public static void main(String[] args) throws Exception {
			getToken http = new getToken();

			System.out.println("Testing 1 - Send Http GET request");
			http.sendGet();

}
		
		public void sendGet() throws Exception {
			final String USER_AGENT = "Mozilla/5.0";
			final String tokenBot = "";
			final String channel = "anime_lovers";
			//zettamix U033ZD3LR - anime_lovers G0F0QGSN5
			final String message = "shi";
			final boolean asUser = true;
			final String coreURL = "https://slack.com/api/chat.postMessage?token="+tokenBot+"&channel="+channel+"&text="+message+"&as_user="+asUser;

			URL obj = new URL(coreURL + tokenBot);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + coreURL);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}
}
/*
		// HTTP POST request
		private void sendPost() throws Exception {

			String url = "https://selfsolve.apple.com/wcResults.do";

			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);

			// add header
			post.setHeader("User-Agent", USER_AGENT);

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
			urlParameters.add(new BasicNameValuePair("cn", ""));
			urlParameters.add(new BasicNameValuePair("locale", ""));
			urlParameters.add(new BasicNameValuePair("caller", ""));
			urlParameters.add(new BasicNameValuePair("num", "12345"));

			post.setEntity(new UrlEncodedFormEntity(urlParameters));

			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " + 
	                                    response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result.toString());

		}*/

