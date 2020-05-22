final SSLContext sslcontext = SSLContexts.custom()
        .setProvider(Conscrypt.newProvider())
        .build();
final SSLConnectionSocketFactory sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
        .setSslContext(sslcontext)
        .build();
final HttpClientConnectionManager cm = PoolingHttpClientConnectionManagerBuilder.create()
        .setSSLSocketFactory(sslSocketFactory)
        .build();
try (CloseableHttpClient httpclient = HttpClients.custom()
        .setConnectionManager(cm)
        .build()) {

    final HttpGet httpget = new HttpGet("https://www.wikipedia.org/");

    System.out.println("Executing request " + httpget.getMethod() + " " + httpget.getUri());

    final HttpClientContext clientContext = HttpClientContext.create();
    try (CloseableHttpResponse response = httpclient.execute(httpget, clientContext)) {
        System.out.println("----------------------------------------");
        System.out.println(response.getCode() + " " + response.getReasonPhrase());

        final SSLSession sslSession = clientContext.getSSLSession();
        if (sslSession != null) {
            System.out.println("SSL protocol " + sslSession.getProtocol());
            System.out.println("SSL cipher suite " + sslSession.getCipherSuite());
        }
    }
}