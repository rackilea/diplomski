public static void main (String[] args){
  HttpClient httpclient = new DefaultHttpClient();
  // Note that the specified port 443 corresponds with the SSL service
  ((AbstractHttpClient) httpclient).getCredentialsProvider().setCredentials(
new AuthScope("www.moneytrackin.com", 443),
new UsernamePasswordCredentials("user", "password"));
  // Https page to access
  HttpGet httpget = new HttpGet("https://www.moneytrackin.com/api/rest/getBalance");
  HttpResponse response;

  try {
      response = httpclient.execute(httpget);

      System.out.println("State: "+response.getStatusLine().toString());
      HttpEntity entity = response.getEntity();

      if (entity != null) {
          InputStream instream = entity.getContent();
          String result= convertStreamToString(instream);
          System.out.println("Data: "+result);
          instream.close();
      }

  } catch (ClientProtocolException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
  } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
  }