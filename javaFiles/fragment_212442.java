@Bean
public DataSource dataSource() {
    DriverManagerDataSource dataSource= new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    // adjust the following to your environment
    dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
    dataSource.setUsername("root");
    dataSource.setPassword("secret");
}