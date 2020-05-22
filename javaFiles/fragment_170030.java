private HttpClient createHttpClientOrProxy() {

    HttpClientBuilder hcBuilder = HttpClients.custom();

    // Set HTTP proxy, if specified in system properties
    if( isSet(System.getProperty("http.proxyHost")) ) {
        int port = 80;
        if( isSet(System.getProperty("http.proxyPort")) ) {
            port = Integer.parseInt(System.getProperty("http.proxyPort"));
        }
        HttpHost proxy = new HttpHost(System.getProperty("http.proxyHost"), port, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        hcBuilder.setRoutePlanner(routePlanner);
    }

    CloseableHttpClient httpClient = hcBuilder.build();

    return httpClient;
}