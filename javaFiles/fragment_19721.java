@Configuration
public WebserviceConfiguration {

    @Inject
    private FooEndpoint fooEndpoint;

    @Bean    
    public SpringBinding fooEndpoint() throws Exception {
        return bind(fooEndpoint, "ws/bar");
    }

    private SpringBinding bind(BaseEndpoint endpoint, String url) throws Exception {
        SpringService springService = new SpringService();
        springService.setBean(endpoint);
        SpringBinding binding = new SpringBinding();
        binding.setService(springService.getObject());
        binding.setUrl(url);
        return binding;
    }

}