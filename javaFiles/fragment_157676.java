...
String uri = "http://" + serverIp + ":" + serverPort + "/hrm/alerts/" + agentId + "/" + date + "/" + resultSetRowCount;

System.out.println(uri);

try 
{

   // create HTTP Client
   HttpClient httpClient = HttpClientBuilder.create().build();

   PostMethod post = new PostMethod(uri);

   RequestEntity requestEntity = new StringRequestEntity(payload, "application/xml", null/*charset default*/);

   post.setRequestEntity(requestEntity);

   int iResult = httpclient.executeMethod(post);

   // get the status code using post.getStatusCode()                
   // you can get the response using post.getResponseBodyAsString()

   // Check for HTTP response code: 200 = success
   if (post.getStatusCode() != 200) {
      throw new RuntimeException("Failed : HTTP error code : " + post.getStatusCode());
   }

} catch (ClientProtocolException e) {
     e.printStackTrace();
} catch (IOException e) {
     e.printStackTrace();
}