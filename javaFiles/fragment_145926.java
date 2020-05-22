@Bean
  public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
    PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
    poolingConnectionManager.setMaxTotal(restTemplateProps.getMaxConnectionsPerPool());
    poolingConnectionManager.setDefaultMaxPerRoute(restTemplateProps.getMaxDefaultConnectionPerRoute());
    CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(poolingConnectionManager).build();
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
        new HttpComponentsClientHttpRequestFactory(client);
    clientHttpRequestFactory.setConnectTimeout(restTemplateProps.getConnectionTimeout());
    clientHttpRequestFactory.setReadTimeout(restTemplateProps.getSocketTimeout());
    return clientHttpRequestFactory;
  }

  @Bean
  public RestTemplate authRestTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder.requestFactory(new ClientHttpRequestFactorySupplier()).build();
  }