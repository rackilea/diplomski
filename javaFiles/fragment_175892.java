PoolingAsyncClientConnectionManager cm = PoolingAsyncClientConnectionManagerBuilder.create()
        .setTlsStrategy(ConscryptClientTlsStrategy.getSystemDefault())
        .build();
CloseableHttpAsyncClient client = HttpAsyncClients.custom()
        .setVersionPolicy(HttpVersionPolicy.NEGOTIATE)
        .setConnectionManager(cm)
        .build();