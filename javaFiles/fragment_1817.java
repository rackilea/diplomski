final SSLContextBuilder sslContextBuilder = new SSLContextBuilder().loadTrustMaterial(null,
        new TrustSelfSignedStrategy());
final PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(
        new DefaultConnectingIOReactor(), 
        RegistryBuilder.<SchemeIOSessionStrategy>create()
            .register("http", NoopIOSessionStrategy.INSTANCE)
            .register("https", new SSLIOSessionStrategy(sslContextBuilder.build(), NoopHostnameVerifier.INSTANCE))
            .build());
cm.setMaxTotal(MAX_POOL_SIZE);
cm.setDefaultMaxPerRoute(MAX_CONN_PER_ROUTE);

this.httpClient = HttpAsyncClients.custom()
        .setDefaultRequestConfig(requestConfig)
        .setKeepAliveStrategy((httpResponse, httpContext) -> 0)
        .setDefaultHeaders(Arrays.asList(doNotKeepAlive, closeConnection))
        .setConnectionManager(cm)
        .build();