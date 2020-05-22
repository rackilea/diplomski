public ApiService() {
    mClient = new OkHttpClient();
    mClient.setConnectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
    mClient.setReadTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
    mClient.setCache(getCache());
    mClient.setSslSocketFactory(getSSL());
}

protected SSLSocketFactory getSSL() {
    try {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        InputStream cert = getAppContext().getResources().openRawResource(R.raw.client);
        Certificate ca = cf.generateCertificate(cert);
        cert.close();

        // creating a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        return new AdditionalKeyStore(keyStore);
    } catch(Exception e) {
        e.printStackTrace();
    }
    return null;
}