public void startServer() throws IOException {
    final URI baseUri = UriBuilder.fromUri("http://0.0.0.0").port(serverPort).build();
    System.out.println("Starting media server at: " + baseUri);
    final ResourceConfig config = new ResourceConfig(SseResource.class, SseFeature.class);
    server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
  }