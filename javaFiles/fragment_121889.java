@Component
public class MyComponent implements InitializingBean {
    @Autowired
    private Environment env; // null

    @Autowired
    public MyComponent(ConfigurationUtils configUtils /* not null */) {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialized environment: " + env);
    }
}