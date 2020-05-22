SSLContext sslContext = SSLContexts.custom()
        .loadTrustMaterial(null, new TrustStrategy() {

            @Override
            public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                return true;
            }
        })
        .useTLS()
        .build();