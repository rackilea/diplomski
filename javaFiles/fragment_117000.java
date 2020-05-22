URL url=new URL("http://www.google.com/");
HttpURLConnection cn=(HttpURLConnection) url.openConnection();

// Configure URLConnection here...
cn.setRequestMethod("POST");            // Use a POST request
cn.setDoOutput(true);                   // We'll send a request body
OutputStream body=cn.getOutputStream(); // Send our output...
try {
    // Do output...
}
finally {
    body.close();
}
InputStream response=cn.getInputStream();
try {
    // Get our request method
    String requestMethod=cn.getRequestMethod();            // POST
    Map<String,List<String>> headers=cn.getHeaderFields(); // Check other response headers

    // Handle input...
}
finally {
    response.close();
}