public Connection dbConnector(){

    try {
        // Load the JDBC driver
        Class.forName(driverName);
        // Create a connection to the database
        connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException e) {
        // Could not find the database driver
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}