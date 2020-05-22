@Autowired
private ConfigurableEnvironment env;

@Autowired
private ConfigurableApplicationContext applicationContext;

@Autowired
private ContextRefresher refresher;

public void setConfigUri(String uri) throws Exception {
    MutablePropertySources propertySources = env.getPropertySources();
    Map<String, Object> map = new HashMap<>();
    map.put("spring.cloud.config.uri", uri);
    propertySources.addFirst(new MapPropertySource("defaultProperties", map));
    applicationContext.setEnvironment(env);
}

public void refreshObjects() throws Exception {
    refresher.refresh();
}