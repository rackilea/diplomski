@Configuration
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean factoryBean() {
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

      return factory;
  }

  @Bean
  public PlatformTransactionManager transactionManager(){
     JpaTransactionManager transactionManager = new JpaTransactionManager();
     transactionManager.setEntityManagerFactory(factoryBean().getObject() );
     return transactionManager;
  }
}