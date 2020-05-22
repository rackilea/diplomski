@Autowired
private ResourceLoader rl;


@Bean
public LocalSessionFactoryBean sessionFactory() throws IOException {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setMappingLocations(loadResources());
    return sessionFactoryBean;
}

public Resource[] loadResources() {
    Resource[] resources = null;
    try {
        resources = ResourcePatternUtils.getResourcePatternResolver(rl)
            .getResources("classpath:/hibernate/*.hbm.xml");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return resources;
}