package com.ds.portlet.library;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class client_post {

     private final String USER_AGENT = "Mozilla/5.0";

     public static void main(String[] args) throws Exception {

             client_post http = new client_post();

             System.out.println("\nSending Http POST request");
             http.sendPost();

     }
     // HTTP POST request
     private void sendPost() throws Exception {

             //String url =<host:port/create/service>
             String url = "http://yahoo.com";
//             String EncoderUrl = URLEncoder.encode(url, "UTF-8");
             URL obj = new URL(url);
             HttpURLConnection con = (HttpURLConnection) obj.openConnection();

             //add reuqest header
             con.setRequestMethod("POST");
             con.setRequestProperty("User-Agent", USER_AGENT);
             con.setRequestProperty("Accept-Language","en-US,en;q=0.5");

             String urlParameters = "<string base64>";
// Send post request
             con.setDoOutput(true);
             DataOutputStream wr = new DataOutputStream(con.getOutputStream());
             wr.writeBytes(urlParameters);
             wr.flush();
             wr.close();

             int responseCode = con.getResponseCode();
             System.out.println("\nSending 'POST' request to URL : " + url);
             System.out.println("Post parameters : " + urlParameters);
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
            System.out.println(response.toString());

       }

}