<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>


<%
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String url = "jdbc:sqlserver://MSI;databaseName=LeadManagement;user=sa;password=123456;";
    Connection connection = DriverManager.getConnection(url);   
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery("select * from userDetail");
%>