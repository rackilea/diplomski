@Configuration
@PropertySource("application.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("application.db.driver"));
        dataSource.setUrl(env.getProperty("application.db.url"));
        dataSource.setUsername(env.getProperty("application.db.username"));
        dataSource.setPassword(env.getProperty("application.db.password"));
        return dataSource;
    }
}