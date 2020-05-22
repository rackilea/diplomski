SSLContext context = SSLContext.getInstance("TLSv1.2");
TrustManager[] trustManager = new TrustManager[] {
    new X509TrustManager() {
       public X509Certificate[] getAcceptedIssuers() {
           return new X509Certificate[0];
       }
       public void checkClientTrusted(X509Certificate[] certificate, String str) {}
       public void checkServerTrusted(X509Certificate[] certificate, String str) {}
    }
};
context.init(null, trustManager, new SecureRandom());

SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context,
        SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

HttpClient client = HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();