HttpRoutePlanner routePlanner = new SystemDefaultRoutePlanner(new MyProxySelector());

HttpComponentsClientHttpRequestFactory clientHttpRequestFactory 
    = new HttpComponentsClientHttpRequestFactory(
        HttpClientBuilder.create()
            .setRoutePlanner(routePlanner)
            .build());
restTemplate = new RestTemplate(clientHttpRequestFactory);