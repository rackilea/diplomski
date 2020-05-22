@Configuration
public class LiquibaseConfigurer {

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource oltpDataSource;

    @Bean
    @DependsOn
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/liquibase-changelog.xml");
        liquibase.setDataSource(oltpDataSource);
        return liquibase;
    }
}