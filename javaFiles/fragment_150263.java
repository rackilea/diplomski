ComboPooledDataSource dataSource = new ComboPooledDataSource(); 
dataSource.setDriverClass("org.postgresql.Driver"); 
dataSource.setJdbcUrl("jdbc:postgresql://localhost/testdb");
dataSource.setUser("dbuser");
dataSource.setPassword("dbpassword"); 
// ...

Connection connection = null;
// ...
try {
    connection = dataSource.getConnection();
    // ...
} finally {
    // ...
    if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {} // Always close resources in finally!
}