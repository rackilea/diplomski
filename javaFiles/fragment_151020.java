@Test
    public void callGoogleWithRootCA() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, KeyManagementException {
        String trustStorePath = "keystores-for-unit-tests/truststore.jks";
        String trustStorePassword = "secret";

        KeyStore trustStore;

        try(InputStream keystoreInputStream = this.getClass().getClassLoader().getResourceAsStream(trustStorePath)) {
            if (isNull(keystoreInputStream)) {
                throw new RuntimeException(String.format("Could not find the keystore file with the given location %s", trustStorePath));
            }

            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(keystoreInputStream, trustStorePassword.toCharArray());
            trustStore = keystore;
        }

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        HttpsURLConnection connection = (HttpsURLConnection) new URL("https://www.google.com").openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());
        connection.setRequestMethod("GET");
        String responseBody = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
        int responseCode = connection.getResponseCode();

        assertThat(responseCode).isEqualTo(200);
    }