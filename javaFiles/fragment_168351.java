@Bean
public DataSource dataSource() {
    BoneCPDataSource dataSource = new BoneCPDataSource();

    dataSource.setDriverClass("org.postgresql.Driver");
    dataSource.setJdbcUrl("jdbc:postgresql://localhost/oauthDB");
    dataSource.setUsername("my_username");
    dataSource.setPassword("*****");

    return dataSource;
}