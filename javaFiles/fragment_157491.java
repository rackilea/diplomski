final WebClient webClient = WebClient
  .builder()
  .baseUrl("http://localhost")
  .build();
webClient
  .get()
  .uri(uriBuilder -> uriBuilder.pathSegment("api", "v2", "json", "test").build())
  .exchange();