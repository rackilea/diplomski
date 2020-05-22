@Bean
public HttpComponentsMessageSender webServiceMessageSender() {

  final HttpClient httpClient = buildHttpClient(5*1000, 5*1000, 2, true);
  final HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(httpClient);
  return messageSender;
}

@SuppressWarnings("resource")
private static HttpClient buildHttpClient(final int connectionTimeout, final int socketTimeout, final int retryCount, final boolean trustAll) {

    // timeout config
    final RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectionTimeout).setSocketTimeout(socketTimeout).build();

    // trust all (if selected)
    SSLConnectionSocketFactory sslSocketFactory = null;
    if (trustAll) {
        try {
            final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustAllStrategy()).build();
            sslSocketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new RuntimeException("could not initialize SSL context, reason: " + e.getMessage(), e);
        }
    }

    // socket factory
    final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", trustAll ? sslSocketFactory : SSLConnectionSocketFactory.getSocketFactory()).build();

    // retry handler
    final HttpRequestRetryHandler retryHandler = new SimpleRetryHandler(retryCount);

    // build client
    final HttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
        .setConnectionManager(new PoolingHttpClientConnectionManager(socketFactoryRegistry)).setRetryHandler(retryHandler)
        .addInterceptorFirst(new RemoveSoapHeadersInterceptor()).build();

    return httpClient;
}