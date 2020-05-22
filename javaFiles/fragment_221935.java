Connection connection = null;
    String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcps)(HOST=192.168.200.191)(PORT=1522))(CONNECT_DATA=(SERVICE_NAME=NNVSDB)))";

    Properties props = new Properties();
    props.setProperty("user", "dbuser");
    props.setProperty("password", "dbpass");

    //Single sign on
    props.setProperty("javax.net.ssl.trustStore", "C:\\oracle\\wallet\\cwallet.sso");
    props.setProperty("javax.net.ssl.trustStoreType","SSO");
    props.setProperty("javax.net.ssl.keyStore","C:\\oracle\\wallet\\cwallet.sso");
    props.setProperty("javax.net.ssl.keyStoreType","SSO");
    props.setProperty("oracle.net.authentication_services","(TCPS)");

    /* Load the database driver */
    try
    {
        Security.addProvider(new oracle.security.pki.OraclePKIProvider());
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        connection = DriverManager.getConnection(url,props);
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
    catch (SQLException ex) {
    ex.printStackTrace();
}