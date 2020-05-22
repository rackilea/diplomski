CloseableHttpClient httpClient = HttpClientBuilder.create()
        .setSSLContext(SSLContexts.createSystemDefault())
        .build();

SSLContext customSSlContext = SSLContexts.custom()
        .loadKeyMaterial(new File("my-keystore.jks"), "sectret".toCharArray(),  "sectret".toCharArray())
        .build();

Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", new SSLConnectionSocketFactory(customSSlContext))
        .build();

HttpClientContext clientContext = HttpClientContext.create();
clientContext.setAttribute("http.socket-factory-registry", socketFactoryRegistry);
try (CloseableHttpResponse response = httpClient.execute(new HttpGet("https://host/stuff"), clientContext)) {
    System.out.println(response.getStatusLine());
    EntityUtils.consume(response.getEntity());
}