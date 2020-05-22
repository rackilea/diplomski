ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(schemeRegistry);
...
DefaultHttpClient httpClient = new DefaultHttpClient(cm, params);
httpClient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
    @Override
    public boolean retryRequest(IOException exception, int executionCount, 
                                HttpContext context) {
        if (executionCount > 3) {
           LOGGER.warn("Maximum tries reached for client http pool ");
                return false;
        }
        if (exception instanceof org.apache.http.NoHttpResponseException) {
            LOGGER.warn("No response from server on " + executionCount + " call");
            return true;
        }
        return false;
      }
   });