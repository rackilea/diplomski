SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext(), new NoopHostnameVerifier());
CloseableHttpClient httpclient = HttpClients.custom()
        .setMaxConnPerRoute(20)
        .setMaxConnTotal(200)
        .setSSLSocketFactory(csf)
        .build();