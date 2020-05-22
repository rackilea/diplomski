public Connection getConn() {
    Connection conn = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        if(System.getenv("MY_ENVIRONMENT") == "development") {
            String hostname = "localhost";
            String username = "root";
            String password = "root";
        }
        conn = DriverManager.getConnection("jdbc:mysql:///mydb", username, password);
    } catch(Exception e) {
        // handle the exception in a meaningful way - do not just rethrow it!
    }
    return conn;
}