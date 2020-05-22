DefaultHttpClient httpclient = new DefaultHttpClient();

HttpContext localContext = new BasicHttpContext();
HttpGet httpget = new HttpGet("http://localhost:8080/"); 
HttpResponse response = httpclient.execute(httpget, localContext);
// here:
HttpHost target = (HttpHost) localContext.getAttribute(
        ExecutionContext.HTTP_TARGET_HOST);