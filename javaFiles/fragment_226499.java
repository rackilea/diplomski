@Override
    public void addViewControllers(ViewControllerRegistry registry) {

            registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs?group=restful-api");
            registry.addRedirectViewController("/documentation/swagger-resources/configuration/ui","/swagger-resources/configuration/ui");
            registry.addRedirectViewController("/documentation/swagger-resources/configuration/security","/swagger-resources/configuration/security");
            registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry
                   .addResourceHandler("/documentation/swagger-ui.html**")
                   .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
            registry
                   .addResourceHandler("/documentation/webjars/**")
                   .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }