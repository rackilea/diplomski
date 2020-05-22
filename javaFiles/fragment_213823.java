@Service
class PropertyService implements InitializingBean {

    @Autowired
    private Environment env;

    private static PropertyService instance;

    public void method() {
        String url = env.getProperty("service.url");
        // ...
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public static PropertyService get() {
        return instance;
    }
}