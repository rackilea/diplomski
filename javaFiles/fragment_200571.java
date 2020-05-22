@Configuration
@EnableTransactionManagement
public class DatasourceConfiguration {

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        AbstractRoutingDataSource dataSource = new TenantSourceRouter();

        Map<Object, Object> targetDataSources = new HashMap<>();

        targetDataSources.put("ALBANY", albanyDatasource());
        targetDataSources.put("BUFFALO", buffaloDatasource());

        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(albanyDatasource());

        return dataSource;
    }

    public DataSource albanyDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("company.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("company.datasource.albany.jdbc-url"));
        dataSource.setUsername(env.getProperty("company.datasource.albany.username"));
        dataSource.setPassword(env.getProperty("company.datasource.albany.password"));

        return dataSource;
    }

    public DataSource buffaloDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("company.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("company.datasource.buffalo.jdbc-url"));
        dataSource.setUsername(env.getProperty("company.datasource.buffalo.username"));
        dataSource.setPassword(env.getProperty("company.datasource.buffalo.password"));

        return dataSource;
    }

}