@Bean(name="key1")
public RestTemplate restTemplate1()
{
    return new RestTemplate(clientHttpRequestFactory1());
}

@Bean(name="key2")
public RestTemplate restTemplate2()
{
    return new RestTemplate(clientHttpRequestFactory2());
}

@Bean
public ClientHttpRequestFactory clientHttpRequestFactory1()
{
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient1());
    //some config...
    return factory;
}


@Bean
public ClientHttpRequestFactory clientHttpRequestFactory2()
{
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient2());
    //some config...
    return factory;
}

public HttpClient httpClient1()
{
    //some config here too..
}

public HttpClient httpClient2()
{
    //some config here too..
}