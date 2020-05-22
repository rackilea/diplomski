private static final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    private static final String accessDBURLSuffix = ";DriverID=22;READONLY=false}";

    // Initialize the JdbcOdbc Bridge Driver
    static {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch(ClassNotFoundException e) {
            System.err.println("JdbcOdbc Bridge Driver not found!");
        }
    }

    /** Creates a Connection to a Access Database */
    public static Connection getAccessDBConnection(String filename) throws SQLException {
        filename = filename.replace('', '/').trim();
        String databaseURL = accessDBURLPrefix + filename + accessDBURLSuffix;
        return DriverManager.getConnection(databaseURL, "", "");
    }