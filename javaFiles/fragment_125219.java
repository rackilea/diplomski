public class JwtAuthHandler implements HttpHandler {

  AttachmentKey<JwtToken> JWT_TOKEN = AttachmentKey.create(JwtToken.class);

  private final HttpHandler next;
  public JwtAuthHandler(HttpHandler next) {
    this.next = next;
  }

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception {
    ...
    JWT.verifyToken(jwt)
        .addListener(token -> {
          if (token != null) {
            exchange.putAttachment(JWT_TOKEN, token);
            next.handleRequest(exchange);
          } else {
            // return http 400, cause: JWT invalid
            httpServerExchange.setStatusCode(StatusCodes.UNAUTHORIZED);
            httpServerExchange.getResponseSender().send(Variables.Errors.INVALID_JWT);
          }
        });
  }
}