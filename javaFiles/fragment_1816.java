final SSLContextBuilder sslContextBuilder = new SSLContextBuilder().loadTrustMaterial(null,
        new TrustSelfSignedStrategy());
this.httpClient = HttpAsyncClients.custom()
        .setDefaultRequestConfig(requestConfig)
        .setKeepAliveStrategy((httpResponse, httpContext) -> 0)
        .setDefaultHeaders(Arrays.asList(doNotKeepAlive, closeConnection))
        .setSSLContext(sslContextBuilder.build())
        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
        .setMaxConnTotal(MAX_POOL_SIZE)
        .setMaxConnPerRoute(MAX_CONN_PER_ROUTE)
        .build();