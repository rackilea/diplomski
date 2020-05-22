@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public MyService myTransactionalService(DomainRepository domainRepository) {
        return new MyServiceImpl(domainRepository);
    }

    @Bean
    public DomainRepository domainRepository(JdbcTemplate template){
        return new JpaAndJdbcDomainRepository(template);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }
}