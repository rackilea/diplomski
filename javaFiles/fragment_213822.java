@Autowired
private Environment env;

public void method() {
    String url = env.getProperty("service.url");
    // ...
}