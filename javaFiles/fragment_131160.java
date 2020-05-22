@Configuration
@Import({SpringDataRestConfiguration.class})
public class SwaggerConfig {

    @Autowired
    @SuppressWarnings({"UnusedDeclaration"})
    private ServletContext servletContext;

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(relativePath())
                .select()
                .apis(RequestHandlerSelectors.any())
//                .paths(paths2())
                .build();
    }
    // Select only a few
    private Predicate<String> paths2() {
        return and(
                (regex("/fixing.*")),
                (regex("/api.*")));
    }
    // Exclude these 
    private Predicate<String> paths() {
        return and(
                not(regex("/error.*")),
                not(regex("/metrics.*")),
                not(regex("/jolokia.*")),
                not(regex("/health.*")),
                not(regex("/env.*")),
                not(regex("/metrics.*")),
                not(regex("/info.*")),
                not(regex("/mappings.*")),
                not(regex("/trace.*")),
                not(regex("/dump.*")),
                not(regex("/heapdump.*")),
                not(regex("/configprops.*")),
                not(regex("/beans.*")),
                not(regex("/autoconfig.*")),
                not(regex("/logfile.*")),
                not(regex("/shutdown.*")),
                not(regex("/actuator.*")));
    }
}