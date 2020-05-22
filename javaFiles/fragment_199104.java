WebClient client = WebClient.create(vertx);

client
  .get(80, "sunet.se", "/")
  .send(ar -> {
    if (ar.succeeded()) {
      // Obtain response
      HttpResponse<Buffer> response = ar.result();
      System.out.println("Received response with status code" + response.statusCode());
    } else {
      System.out.println("Something went wrong " + ar.cause().getMessage());
    }
  });