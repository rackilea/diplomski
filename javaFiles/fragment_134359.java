@Bean
 public RestTemplateBuilder restTemplateBuilder() {
   return new RestTemplateBuilder()
        .rootUri(rootUri)
        .basicAuthorization(username, password);
  }