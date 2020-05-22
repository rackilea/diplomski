Class.forName("oracle.jdbc.OracleDriver");
//notice i don't use the class oracle.jdbc.driver.OracleDriver
//since that is deprecated class

String URL = "jdbc:oracle:thin:@localhost:1521/XE";

conn = DriverManager.getConnection(URL, "ChrisGraves", "<password>"); 
//put the username and password as separate parametars