@Override
public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    log.info("Request {} called", exchange.getRequest().getPath().value());
    System.out.println("Tokent authenitcation..");

    ServerHttpResponse response = exchange.getResponse();
    return getAuthorization(exchange.getRequest())
      .doOnError(error -> exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)))
    .then(chain.filter(exchange));
}