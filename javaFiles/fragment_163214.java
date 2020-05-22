@Bean
public TilesConfigurer getTilesConfigurer() {
    TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
    ...
    configurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
    return configurer;
}