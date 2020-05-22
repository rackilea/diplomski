Connection connection = null;

try {
   // Load the JDBC driver
   String driverName = "oracle.jdbc.driver.OracleDriver";
   Class.forName(driverName);

   // Create a connection to the database
   String serverName = "127.0.0.1";
   String portNumber = "1521";
   String sid = "mydatabase";
   String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
   String username = "username";
   String password = "password";
   connection = DriverManager.getConnection(url, username, password);
} catch (ClassNotFoundException e) {
   // Could not find the database driver
} catch (SQLException e) {
   // Could not connect to the database
}