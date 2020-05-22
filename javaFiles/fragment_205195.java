@ApplicationPath("/sample")
public class MyApplication extends Application {

    public MyApplication(@Context ServletConfig servletConfig) {
        super();
        OpenAPI oas = new OpenAPI();
        Info info = new Info()
            .title("Swagger Sample App bootstrap code")
            .description("This is a sample server Petstore server.  You can find out more about Swagger " +
                    "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
                    "you can use the api key `special-key` to test the authorization filters.")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact()
                    .email("apiteam@swagger.io"))
            .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        oas.info(info);
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
            .openAPI(oas)
            .prettyPrint(true)
            .resourcePackages(Stream.of("io.swagger.sample.resource").collect(Collectors.toSet()));

        try {
            new JaxrsOpenApiContextBuilder()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(oasConfig)
                .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}