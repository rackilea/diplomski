private static HttpClient createHttpClient(){
    RequestConfig config = RequestConfig.custom()
            .setSocketTimeout(TIMEOUT)
            .setConnectTimeout(TIMEOUT)
            .build();

    HttpClientBuilder hcBuilder = HttpClients.custom();
    hcBuilder.setDefaultRequestConfig(config);

    return hcBuilder.build();
}