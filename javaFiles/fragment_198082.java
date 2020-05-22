public ApplicationInitializer(@Context ServletConfig servletConfig) {
    super();
    OpenAPI oas = new OpenAPI();
    try {
        Set<String> resource = new HashSet<>();
        resource.add("my.company.api.path");
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .resourcePackages(resource);

        OpenApiContext oac = new JaxrsOpenApiContextBuilder()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(oasConfig)
                .buildContext(true);
        oac.read();
    } catch (OpenApiConfigurationException e) {
        throw new RuntimeException(e.getMessage(), e);
    }
}