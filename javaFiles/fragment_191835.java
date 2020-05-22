@Component
@Configuration
@PropertySource("classpath:test.properties")
public class TestClass {

    @Autowired
    Environment environment;

    public String test (String property) {

        final String value = environment.getProperty(property);

        System.out.println("========> Property: " + value);
        // TODO: Something with the prop val

        return value;

    }

}