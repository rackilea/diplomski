RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

private ClientHttpRequestFactory getClientHttpRequestFactory() {
    int timeout = 3000;
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
    new HttpComponentsClientHttpRequestFactory();
    clientHttpRequestFactory.setConnectTimeout(timeout);
    clientHttpRequestFactory.setReadTimeout(timeout);
    return clientHttpRequestFactory;
}