public class Example {

  public static void main(String[] args) {
    Undertow server = Undertow.builder()
        .addListener(8080, "localhost")
        .setHandler(new HttpHandler() {
          public void handleRequest(HttpServerExchange exchange)
              throws Exception {

            if (valueIsPresentInCache(exchange)) {
              getValueFromCache();  // non-blocking, can be done from IO thread           
            } else {

              if (exchange.isInIoThread()) {
                exchange.dispatch(this);
                // we return immediately, otherwise this request will be
                // handled both in IO thread and a Worker thread, throwing
                // an exception
                return;
              }

              fetchValueFromDatabase(); // blocking!!!

            }
          }
        })
        .build();
    server.start();
  }
}