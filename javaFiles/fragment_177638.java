Undertow.builder().addHttpListener(8080, "0.0.0.0")
  .setHandler(Handlers.path()

    // Controllers
    .addPrefixPath("/controller", Handlers.routing()
        .post("/{id}", exchange -> {
          String id = exchange.getQueryParameters().get("id").getFirst();
        }))

    // Serve your file, preserving any route information
    .addPrefixPath("/app.js",  exchange -> {
        Path p = Paths.get("/path/to/app.js");
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/javascript");
        exchange.getResponseSender().send(
          ByteBuffer.wrap(Files.readAllBytes(p))
      )})
).build().start();