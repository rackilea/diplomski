@Configuration
@EnableJpaRepositories(basePackages = "org.baeldung.repository")
@PropertySource("test1-dbA.properties")
@EnableTransactionManagement
public class DB1Config {
        @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }
// ...
}