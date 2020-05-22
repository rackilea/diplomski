String userName ="username";
String password ="password";

String url ="jdbc:sqlserver://myDB\\SQLServer;databaseName=name";

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection conn = DriverManager.getConnection(url, userName, password);