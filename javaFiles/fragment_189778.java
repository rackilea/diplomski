String url="jdbc:mysql://localhost:3306/database1";
String userName="root";
String password="Newyear2016!";
try {

    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con=DriverManager.getConnection(url,username,password);