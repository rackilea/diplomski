DefaultConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(IOReactorConfig.DEFAULT);
SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(new TrustStrategy() {
    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return true;
    }
}).build();
PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(
        ioReactor,
        RegistryBuilder.<SchemeIOSessionStrategy>create()
                .register("http", NoopIOSessionStrategy.INSTANCE)
                .register("https", new SSLIOSessionStrategy(sslContext))
                .build());
CloseableHttpPipeliningClient httpClient = HttpAsyncClients.createPipelining(cm);
httpClient.start();