@BeforeClass
public static void setUpDataSource() throws Exception {
    try {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();

        OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
        ds.setURL("jdbc:oracle:thin:@xxxxx:1521:xxxxx");
        ds.setUser("myUsername");
        ds.setPassword("myPass");           

        builder.bind("jboss/datasources/myDatasource", ds);
        builder.activate();
    } catch (NamingException ex) {
        ex.printStackTrace();
    }
}