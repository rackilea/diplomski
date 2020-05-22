// this is created & injected by Spring Boot
@Autowired
private RestTemplateBuilder restTemplateBuilder;

@Bean("internal_api")
public RestTemplate internalRestTemplate(@Autowired OAuthConsumerOperations oAuthConsumerOperations) {
    return restTemplateBuilder.build();  // add additional config
}

@Bean("external_api")
public RestTemplate externalRestTemplate(){
    return restTemplateBuilder.build();  // add additional config
}