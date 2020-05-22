public class HttpClientFactoryBean extends AbstractFactoryBean<HttpClient> {

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    protected HttpClient createInstance() throws Exception {
         KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
         TrustStrategy allTrust = new TrustStrategy() {
             @Override
             public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                 return true;
             }
         };

         SSLContext sslcontext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, allTrust).build();

         SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
         CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

         return httpClient;
    }

}