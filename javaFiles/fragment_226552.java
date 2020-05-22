@Bean
public ServiceLocatorFactoryBean serviceLocatorFactoryBean(){
    ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
    bean.setServiceLocatorInterface(MyMapper.class);
    return bean;
}