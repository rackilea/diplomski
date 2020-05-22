@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerDataSource1",
    basePackages = "com.package1",
    transactionManagerRef = "TransactionManagerDataSource1")
public class MasterDBConfig {

   @Bean(name="DataSource1")
   @ConfigurationProperties(prefix = "datasource1.datasource")
   public DataSource dataSource() {
       return DataSourceBuilder.create().build();
   }

   @Bean(name="entityManagerDataSource1")
   public LocalContainerEntityManagerFactoryBean entityManagerDataSource1(EntityManagerFactoryBuilder builder,@Qualifier("DataSource1") DataSource dataSource) {
       return builder.dataSource(dataSource).packages("com.package1").persistenceUnit("DataSource1").build();
    }

   @Bean(name = "TransactionManagerDataSource1")
   public PlatformTransactionManager TransactionManagerDataSource1(@Qualifier("entityManagerDataSource1") EntityManagerFactory entityManagerFactory) {
       return new JpaTransactionManager(entityManagerFactory);
   }
}