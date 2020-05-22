HttpClient httpclient = new DefaultHttpClient();
HttpGet httpget = new HttpGet("http://www.google.com/"); 
ResponseHandler<String> responseHandler = new BasicResponseHandler();    
String responseBody = httpclient.execute(httpget, responseHandler);
// responseBody now contains the contents of the page
System.out.println(responseBody);
httpclient.getConnectionManager().shutdown();