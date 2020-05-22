....
public static void demo() throws IOException {           
     String uri = "http://localhost:8080/HW/hw/helloworld";
     HttpClient httpclient = new DefaultHttpClient();
     HttpGet httpget = new HttpGet(uri);
     HttpResponse response = httpclient.execute(httpget);
     System.out.println(response.getStatusLine().toString());
     HttpEntity entity = response.getEntity();
     System.out.println();
     System.out.println(EntityUtils.toString(entity));       
  }
....