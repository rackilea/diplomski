X509TrustManager trustManager = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] xcs, String string)
                throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] xcs, String string)
                throws CertificateException {}
        public X509Certificate[] getAcceptedIssuers() {
            //Here
            return new X509Certificate[]{};
        }
    };
    .
    .
    .