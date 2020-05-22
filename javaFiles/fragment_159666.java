class Database {
    private Connection con = null;
    private final String connectionString;

    public Database(String connectionString) {
        this.connectionString = connectionString;
    }

    public void connect() throws SQLException {
        if (con != null // if the connection exists
             && !con.isClosed() // and has not been closed 
             && con.isValid(0)) { // and appears to be functioning (with a test timeout of 0ms)
             return; // skip connection creation
        }

        // create the connection
        con = DriverManager.getConnection(connectionString);        
    }

    public void testFunction() {
        try {
            connect();
            // .. do some stuff with the connection ..
        } catch (Exception e) {
            // log or otherwise deal with the error
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.err.println("Failed to close connection: " + e.toString());
            }
        }

    }
}