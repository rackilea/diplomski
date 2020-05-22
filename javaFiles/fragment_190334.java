@Component
@PropertySource("classpath:myProps.properties")
public class MyComponent {

    @Value("${some.property}")
    private String valueFromProperty;

    // You can also use environment
    @Autowired
    private Environment env;

    public void someMethod() {
        String prop = env.getProperty("some.property");
        MyBean bean = new MyBean();
        bean.setProp(prop);
        return bean;
    }
}