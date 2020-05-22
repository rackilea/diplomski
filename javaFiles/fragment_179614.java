@Configuration
@PropertySource("/app.properties")
public class Test {
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(env.getProperty("url"), env.getProperty("username"), env.getProperty("password"));
    }
}