private boolean startup() throws ClientProtocolException, IOException {
   logger.entry();

   HttpPost request = new HttpPost("http://.../StartupServlet");

  RequestConfig requestConfig = RequestConfig.custom()
           .setSocketTimeout(30 * 1000)
           .setConnectionRequestTimeout(30 * 1000)
           .setConnectTimeout(30 * 1000)
           .build();
  request.setConfig(requestConfig);

  CloseableHttpClient client = HttpClients.createDefault();
  CloseableHttpResponse response = client.execute(request);

  if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
     return false;
  }

  logger.exit();
  return true;
}