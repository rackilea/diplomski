// it's singleton by default
@Bean(name = "apiConfigurator") // this is the bean id
public PropertiesFactoryBean factoryBean() {
    PropertiesFactoryBean bean = new PropertiesFactoryBean();
    bean.setLocation(new ClassPathResource("api.properties"));
    return bean;
}