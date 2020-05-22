@Bean(name = "myProperties")
public static PropertiesFactoryBean mapper() {
    PropertiesFactoryBean bean = new PropertiesFactoryBean();
    bean.setLocation(new ClassPathResource("prop_file_name.properties"));
    return bean;
}