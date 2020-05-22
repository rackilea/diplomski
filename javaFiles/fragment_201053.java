@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
       basePackages = {"com.yourpackage.yyyy"},
       entityManagerFactoryRef = "entityManagerFactory2",
       transactionManagerRef = "transactionManager")
       public class SecondPersistenceContextConfig {}
...