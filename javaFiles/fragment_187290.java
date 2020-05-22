@Configuration
public class SpringRestConfiguration {

    @Autowired
    @Qualifier("parameters") // Somewhere in your context you should have a bean named 'parameters'. It doesn't matter if it was defined with XML, configuration class or with auto scanning. As long as such bean with the right type and name exists, you should be good.
    private Parameters parameters;

    // @Bean definitions
    ...
}