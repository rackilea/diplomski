@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
    char[] password = "password".toCharArray();

    SSLContext sslContext = SSLContextBuilder.create()
            .loadKeyMaterial(keyStore("classpath:cert.jks", password), password)
            .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();

    HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();
    return builder
            .requestFactory(new HttpComponentsClientHttpRequestFactory(client))
            .build();
}

 private KeyStore keyStore(String file, char[] password) throws Exception {
    KeyStore keyStore = KeyStore.getInstance("PKCS12");
    File key = ResourceUtils.getFile(file);
    try (InputStream in = new FileInputStream(key)) {
        keyStore.load(in, password);
    }
    return keyStore;
}