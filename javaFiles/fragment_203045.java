public static void main(String[] args) throws ClassNotFoundException {
try {
Connection connection = null;

String serverName = "127.0.0.1"; //http://127.0.0.1:8080/apex
String portNumber = "1521";
String sid = "xe"; //xe

String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

String username = "system";
String password = "password";

connection = DriverManager.getConnection(url, username, password);

Statement stmt = connection.createStatement();

ResultSet rset = stmt.executeQuery("select * from employee");

while (rset.next()) 
{
System.out.println(rset.getString(1));
System.out.println(rset.getString(2));
}
stmt.close();

} catch (Exception e) {
System.out.println("Hai " + e);
}
}