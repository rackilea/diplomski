spring.datasource.url = [url]
spring.datasource.username = [username]
spring.datasource.password = [password]
spring.datasource.driverClassName = oracle.jdbc.OracleDriver

@Bean
@ConfigurationProperties(prefix="spring.datasource")
public DataSource dataSource() {
    return new DataSource();
}