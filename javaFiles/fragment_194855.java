@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("FooBar")
                .select()
                //Ignores controllers annotated with @CustomIgnore
                .apis(any()) //Selection by RequestHandler
                        .paths(paths()) // and by paths
                        .build()
                        .apiInfo(apiInfo()
                        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("FooBar",
                "A java server based on SpringBoot",
                "1.0.0",
                null,
                "author","","");
    }

    //Here is an example where we select any api that matches one of these paths
    private Predicate<String> paths() {
        return or(
                regex("/foobar/*.*")
                );
    }
}