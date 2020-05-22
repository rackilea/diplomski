KeyStore dummyTrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
    try {
        dummyTrustStore.load(null, null);
        dummyTrustStore.setCertificateEntry("dummyroot", buildDummyCertificate());
    } catch (CertificateException | IOException e) {
        // handle exception
    }
sslcontext = SSLContexts.custom().loadTrustMaterial(dummyTrustStore, new TrustNoOneStrategy()).build();