@Configuration
@Import(AppConfig.class)
public class InfrastructureConfig {

    @Bean //Creates an in-memory database.
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().build(); 
    }   

    @Bean //Creates our EntityManagerFactory
    public AbstractEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return emf;
    }

    @Bean //Creates our PlatformTransactionManager. Registering both the EntityManagerFactory and the DataSource to be shared by the EMF and JDBCTemplate
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf, DataSource dataSource){
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        tm.setDataSource(dataSource);
        return tm;
    }

}