try {
 String driverName = "com.mysql.jdbc.Driver";
 Class.forName(driverName);

 String serverName = "localhost";
 String mydatabase = "hpdata";
 String url = "jdbc:mysql :// " + serverName + "/" + mydatabase; 

 String username = "root";
 String password = "123456";
 connection = DriverManager.getConnection(url, username, password);
} catch(Exception e) {
 // appropriate action
}