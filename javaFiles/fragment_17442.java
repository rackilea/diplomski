public int num() throws Exception {
 try {
 // This will load the MySQL driver, each DB has its own driver
 Class.forName("com.mysql.jdbc.Driver");
 // Setup the connection with the DB
 connect = DriverManager.getConnection("jdbc:mysql://localhost/testdb?"
 + "user=root&password=");

 // Statements allow to issue SQL queries to the database
 statement = connect.createStatement();
 resultSet = statement.executeQuery("select count(*) from testdb.emg");

 while (resultSet.next()) {
 return resultSet.getInt(1);
 }
} catch (Exception e) {
}