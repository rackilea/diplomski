@BeforeClass
public static void setUpClass() throws Exception {
    try {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");            
        InitialContext ic = new InitialContext();

        ic.createSubcontext("jboss");
        ic.createSubcontext("jboss/datasources");
        ic.createSubcontext("jboss/datasources/myDatasource");

        OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
        ds.setURL("jdbc:oracle:thin:@xxxxx:1521:xxxxx");
        ds.setUser("myUserid");
        ds.setPassword("myPass");

        ic.rebind("jboss/datasources/myDatasource", ds);
    } catch (NamingException ex) {
        ex.printStackTrace();
    }
}