static class ConscriptClientTlsStrategy implements TlsStrategy {

    private final SSLContext sslContext;

    public ConscriptClientTlsStrategy(final SSLContext sslContext) {
        this.sslContext = Args.notNull(sslContext, "SSL context");
    }

    @Override
    public boolean upgrade(
            final TransportSecurityLayer tlsSession,
            final HttpHost host,
            final SocketAddress localAddress,
            final SocketAddress remoteAddress,
            final Object attachment) {
        final String scheme = host != null ? host.getSchemeName() : null;
        if (URIScheme.HTTPS.same(scheme)) {
            tlsSession.startTls(
                    sslContext,
                    host,
                    SSLBufferMode.STATIC,
                    (endpoint, sslEngine) -> {
                        final SSLParameters sslParameters = sslEngine.getSSLParameters();
                        sslParameters.setProtocols(H2TlsSupport.excludeBlacklistedProtocols(sslParameters.getProtocols()));
                        sslParameters.setCipherSuites(H2TlsSupport.excludeBlacklistedCiphers(sslParameters.getCipherSuites()));
                        H2TlsSupport.setEnableRetransmissions(sslParameters, false);
                        final HttpVersionPolicy versionPolicy = attachment instanceof HttpVersionPolicy ?
                                (HttpVersionPolicy) attachment : HttpVersionPolicy.NEGOTIATE;
                        final String[] appProtocols;
                        switch (versionPolicy) {
                            case FORCE_HTTP_1:
                                appProtocols = new String[] { ApplicationProtocols.HTTP_1_1.id };
                                break;
                            case FORCE_HTTP_2:
                                appProtocols = new String[] { ApplicationProtocols.HTTP_2.id };
                                break;
                            default:
                                appProtocols = new String[] { ApplicationProtocols.HTTP_2.id, ApplicationProtocols.HTTP_1_1.id };
                        }
                        if (Conscrypt.isConscrypt(sslEngine)) {
                            sslEngine.setSSLParameters(sslParameters);
                            Conscrypt.setApplicationProtocols(sslEngine, appProtocols);
                        } else {
                            H2TlsSupport.setApplicationProtocols(sslParameters, appProtocols);
                            sslEngine.setSSLParameters(sslParameters);
                        }
                    },
                    (endpoint, sslEngine) -> {
                        if (Conscrypt.isConscrypt(sslEngine)) {
                            return new TlsDetails(sslEngine.getSession(), Conscrypt.getApplicationProtocol(sslEngine));
                        }
                        return null;
                    });
            return true;
        }
        return false;
    }

}

public static void main(String[] args) throws Exception {
    final SSLContext sslContext = SSLContexts.custom()
            .setProvider(Conscrypt.newProvider())
            .build();
    final PoolingAsyncClientConnectionManager cm = PoolingAsyncClientConnectionManagerBuilder.create()
            .setTlsStrategy(new ConscriptClientTlsStrategy(sslContext))
            .build();
    try (CloseableHttpAsyncClient client = HttpAsyncClients.custom()
            .setVersionPolicy(HttpVersionPolicy.NEGOTIATE)
            .setConnectionManager(cm)
            .build()) {

        client.start();

        final HttpHost target = new HttpHost("nghttp2.org", 443, "https");
        final String requestUri = "/httpbin";
        final HttpClientContext clientContext = HttpClientContext.create();

        final SimpleHttpRequest request = SimpleHttpRequests.GET.create(target, requestUri);
        final Future<SimpleHttpResponse> future = client.execute(
                SimpleRequestProducer.create(request),
                SimpleResponseConsumer.create(),
                clientContext,
                new FutureCallback<SimpleHttpResponse>() {

                    @Override
                    public void completed(final SimpleHttpResponse response) {
                        System.out.println(requestUri + "->" + response.getCode() + " " +
                                clientContext.getProtocolVersion());
                        System.out.println(response.getBody());
                        final SSLSession sslSession = clientContext.getSSLSession();
                        if (sslSession != null) {
                            System.out.println("SSL protocol " + sslSession.getProtocol());
                            System.out.println("SSL cipher suite " + sslSession.getCipherSuite());
                        }
                    }

                    @Override
                    public void failed(final Exception ex) {
                        System.out.println(requestUri + "->" + ex);
                    }

                    @Override
                    public void cancelled() {
                        System.out.println(requestUri + " cancelled");
                    }

                });
        future.get();

        System.out.println("Shutting down");
        client.shutdown(CloseMode.GRACEFUL);
    }
}