public class RequestProcessor {
  private RequestProcessor instance = new RequestProcessor();
  private PoolingClientAsyncConnectionManager pcm = null;
  private HttpAsyncClient httpAsyncClient = null;
  private RequestProcessor() {
    // Initialize the PoolingClientAsyncConnectionManager, and the HttpAsyncClient 
  }
  public void process(...) {
    this.httpAsyncClient.execute(httpMethod, 
         new BasicHttpContext(), // Use a separate HttpContext for each request so information is not shared between requests
         new FutureCallback<HttpResponse>() {
      @Override
      public void cancelled() {
        // Do stuff
      }
      @Override
      public void completed(HttpResponse httpResponse) {
        // Do stuff
      }
      @Override
      public void failed(Exception e) {
        // Do stuff
      }
    });
  }
}