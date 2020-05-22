String date = request.getParameter("myDate");
String expr = "call my_package.my_proc(TO_DATE(?, 'DD/MM/YY HH24:MI:SS')";
try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@abc:1521:xyz", "uname", "pw");
  CallableStatement statement = connection.prepareCall(expr);
  statement.setString(1, date)
  statement.execute();
}