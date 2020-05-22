TrustStrategy veryNaive = new TrustStrategy() {
    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        return true;
    }
};

SSLContext sslcontext = SSLContexts.custom()
    .loadTrustMaterial(veryNaive)
    .build();

CloseableHttpClient httpclient = HttpClients.custom()
    .setSSLSocketFactory(new SSLConnectionSocketFactory(sslcontext))
    .build();

try {
    HttpGet httpget = new HttpGet("https://company.com");

    try (CloseableHttpResponse response = httpclient.execute(httpget);) {
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        EntityUtils.consume(entity);
    }
} finally {
    httpclient.close();
}