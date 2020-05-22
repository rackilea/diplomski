//EXAMPLE @Value("${propFile.maxTotalConn}")


@Bean
public RestTemplate createRestTemplate(@Value("${propFile.maxTotalConn}") int maxTotalConn, @Value("${propFile.maxPerChannel}") int maxPerChannel, connTimoutint connTimout) {
   PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
   connectionManager.setMaxTotal(maxTotalConn);
   connectionManager.setDefaultMaxPerRoute(maxPerChannel);

  ...
}