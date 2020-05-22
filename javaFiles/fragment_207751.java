KeyStore keyStore = loadKeystore(keystoreFilename, keystorePassword);
KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
kmf.init(keyStore, keystorePassword.toCharArray());

KeyStore trustStore = loadKeystore(truststoreFilename, truststorePassword);
TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
tmf.init(trustStore);

SSLContext sslContext = SSLContext.getInstance("TLS");
sslContext.init(keyManagers, trustManagers, new java.security.SecureRandom());

URL destinationURL = new URL(origin);
HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
conn.setSSLSocketFactory(sslContext.getSocketFactory());
conn.connect();

return conn.getServerCertificates();

private KeyStore loadKeystore(String keyStoreFilename, String keyStorePassword) {
    try {
        final KeyStore trustStore = KeyStore.getInstance("JKS");
        final InputStream is = new FileInputStream(keyStoreFilename);
        trustStore.load(is, keyStorePassword.toCharArray());

        return trustStore;

    } catch (Exception ex) {
        throw new MyException(ex);
    }
}