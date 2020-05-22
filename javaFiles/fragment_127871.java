@Configuration
@PropertySource(value= {"classpath:application.properties"})
public class DatasourceConfig {

    @Autowired
    Environment environment;

    @Bean
    public DataSource datasource() throws PropertyVetoException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }
}