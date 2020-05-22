@BeforeClass
public static void setUpBeforeClass() throws Exception {

    DriverManagerDataSource dataSource = getDataSource();
    Connection conn = dataSource.getConnection();
    ScriptUtils.executeSqlScript(conn, new ClassPathResource("db_config.sql"));
    ScriptUtils.executeSqlScript(conn, new ClassPathResource("consultas/setup_schema"));
    ScriptUtils.executeSqlScript(conn, new ClassPathResource("db_init.sql"));
    JdbcUtils.closeConnection(conn);

}

@AfterClass
public static void tearDownAfterClass() throws Exception {
    Connection conn = getDataSource().getConnection();
    ScriptUtils.executeSqlScript(conn, new ClassPathResource(
            "db_teardown.sql"));
    JdbcUtils.closeConnection(conn);
}

private static DriverManagerDataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setDriverClassName(driver);
    return dataSource;
}