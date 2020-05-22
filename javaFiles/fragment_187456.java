@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DatasourceConfig {

  @Bean
  @Primary
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(System.getProperty("MYSQL_URL"));
    dataSource.setUsername(System.getProperty("MYSQL_USER"));
    dataSource.setPassword(System.getProperty("MYSQL_PASSWORD"));
    return dataSource;
  }

}