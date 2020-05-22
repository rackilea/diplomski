public class HelloHandler implements HttpHandler {

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    JwtToken token = exchange.getAttachment(JWT_TOKEN);
    ...
  }
}