@Configuration
public class ContextConfiguration {

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/database");
        ds.setUsername("root");
        ds.setPassword("00000");
        return ds;
    }

}