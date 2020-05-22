router.route("/").handler(routingContext -> {
  HttpServerResponse response = routingContext.response();

  Future<String> future = doSomethingAsync();
  future.setHandler(somethingResult -> {
    if (somethingResult.succeeded()) {
      response
        .end(somethingResult.result());
    } else {
      routingContext.fail(500);
    }
  });
});