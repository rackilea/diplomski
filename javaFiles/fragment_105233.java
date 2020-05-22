private PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
    SSLConnectionSocketFactory sslsocketFactory = null;
    try {
        sslsocketFactory = new SSLConnectionSocketFactory(SSLContext.getDefault(), new DefaultHostnameVerifier());
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                                                                .register("https", sslsocketFactory)
                                                                .register("http", PlainConnectionSocketFactory.INSTANCE)
                                                                .build();

    PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry); 
    poolingConnectionManager.setMaxTotal(1000);
    poolingConnectionManager.setDefaultMaxPerRoute(1000);
    // Used these settings instead of constructor parameters (long timeToLive, TimeUnit timeUnit)
    poolingConnectionManager.closeIdleConnections(30, TimeUnit.SECONDS);

    return poolingConnectionManager;
}