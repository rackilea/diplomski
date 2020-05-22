<%@ page import="java.sql.*" %>
<%
try
{
  // create a java mysql database connection
  String myDriver = "com.mysql.jdbc.Driver";
  String myUrl = "jdbc:mysql://localhost:3306/studentEnrollment";
  Class.forName(myDriver);
  Connection conn = DriverManager.getConnection(myUrl, "root", "12");

  // create the java mysql update preparedstatement
  String query = "update etudiants set dv_o_math = ? where first_name = ?";
  PreparedStatement preparedStmt = conn.prepareStatement(query);
  preparedStmt.setInt(1, 15);
  preparedStmt.setString(2,request.getParameter("bt2"));

  // execute the java preparedstatement
  preparedStmt.executeUpdate();

  conn.close();
}catch (Exception e){ }

%>
<h3> The data is successfully updated</h3>