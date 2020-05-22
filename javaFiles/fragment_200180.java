public static void main(String[] args) {
    HashMap<String, Object> props = new HashMap<>();

    ConfigProperties cp = ... // some magic to load, cp is not Spring bean
    // server.port and server.ssl.enabled are properties Spring is aware of - will use it
    props.put("server.port", cp.getPort());
    props.put("server.ssl.enabled", cp.isSslEnabled()); // where you read properties from config.xml
    props.put("custom", cp.getCustom());

    ConfigurableApplicationContext context = new SpringApplicationBuilder()
        .sources(SecurityService.class)                
        .properties(props)
        .run(args);

    SecurityService ss = context.getBean(SecurityService.class);
    // configuration is not Spring managed, so there is not @Autowired in SecurityService 
    ss.setConfiguration(configuration); // problem is, that while it is not Spring bean, you cannot reference it from multiple services
}