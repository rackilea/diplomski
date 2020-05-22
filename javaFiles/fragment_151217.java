@Bean
public DataSource getDataSource() throws SQLException {
    OracleDataSource oracleDs = new OracleDataSource();
    oracleDs.setURL(Secrets.get("DB_URL"));
    oracleDs.setUser(Secrets.get("DB_USER"));
    oracleDs.setPassword(Secrets.get("DB_PASS"));
    // other Oracle related settings...

    HikariDataSource hikariDs = new HikariDataSource();
    hikariDs.setDataSource(oracleDs);
    hikariDs.setConnectionInitSql("ALTER SESSION SET CURRENT_SCHEMA = MY_SCHEMA");

    return hikariDs;
}