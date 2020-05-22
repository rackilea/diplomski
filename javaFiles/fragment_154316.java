public HelloWorld() {

    try {
        setDBSystemDir();
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection dbConnection = null;
        String strUrl = "jdbc:derby:SolofutbolParaguay;create=true";

        try {
            dbConnection = DriverManager.getConnection(strUrl);
            System.out.println("connection created");
            createTable(dbConnection);
            insertRecord(dbConnection);
            listRecord(dbConnection);
            System.out.println("connection close");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

private void setDBSystemDir() {
    // Decide on the db system directory: <userhome>/.addressbook/
    System.setProperty("derby.system.home", "/Users/myuser/futbol