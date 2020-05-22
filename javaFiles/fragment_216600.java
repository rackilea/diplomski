@Bean(name = "key1")
    public RestTemplate restTemplate1() {
        return new RestTemplate(clientHttpRequestFactory(httpClient(/* params */)));
    }

    @Bean(name = "key2")
    public RestTemplate restTemplate2() {
        return new RestTemplate(clientHttpRequestFactory(httpClient(/* params */)));
    }

    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return factory;
    }

    public HttpClient httpClient(/* paramn */) {
        /* create HttpClient using params  */
    }