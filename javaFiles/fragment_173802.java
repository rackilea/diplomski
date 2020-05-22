@BeforeClass
public static void setUpDataSource() throws Exception {
    try {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        DriverAdapterCPDS cpds = new DriverAdapterCPDS();
        cpds.setDriver("oracle.jdbc.OracleDriver");
        cpds.setUrl("jdbc:oracle:thin:@xxxxx:1521:xxxxx");
        cpds.setUser("myUsername");
        cpds.setPassword("myPass");

        SharedPoolDataSource dataSource = new SharedPoolDataSource();
        dataSource.setConnectionPoolDataSource(cpds);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(50);
        builder.bind("jboss/datasources/myDatasource", dataSource);
        builder.activate();
    } catch (NamingException ex) {
        ex.printStackTrace();
    }
}