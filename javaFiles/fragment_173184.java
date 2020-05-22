Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@host:1521:DB", "User","pass_01");
Statement statement = connection.createStatement();   
resultset = statement.executeQuery("select * from employee"); 
while (resultset.next()) {
    System.out.println(resultset.getInt(1) + " " +
    resultset.getInt(2) + " " + 
    resultset.getInt(3) + " " + 
    resultset.getString(4));
}