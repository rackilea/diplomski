@Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
       basePackages = {"com.yourpackage.xxxx"},
       entityManagerFactoryRef = "entityManagerFactory1",
       transactionManagerRef = "transactionManager")
       public class FirstPersistenceContextConfig {}
....