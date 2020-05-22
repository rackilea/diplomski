@ComponentScan("com.acme")
@Configuration
public class SpringConfig
{ 
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        EncryptedPropertySourcesPlaceholderConfigurer p = new EncryptedPropertySourcesPlaceholderConfigurer(new KeyfileDecryptor());
        p.setLocations(
                new ClassPathResource("application.properties"),
                new ClassPathResource("env.properties")
                );
        return p;
    }

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driverclassname}") String driverclassname,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String password)
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverclassname);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}