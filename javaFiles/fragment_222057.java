@Bean
@DependsOn({"dataSource"})
public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(ConfigurableListableBeanFactory beanFactory) {
   // Create the LocalContainerEntityManagerBean like you were

   // Pass beanFactory here so right configuration gets applied
   em.setJpaProperties(additionalProperties(beanFactory));
   return em;
}

private Properties additionalProperties(ConfigurableListableBeanFactory beanFactory) {
  // add your properties here like you were before
  Properties properties = new Properties();

  // THIS HERE IS THE CRITICAL SETTING
  properties.put(
    "hibernate.resource.beans.container", 
     new SpringBeanContainer(beanFactory));

  return properties
}