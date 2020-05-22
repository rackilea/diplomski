<%@ page import="java.sql.*"%>
<%@ page import="javafiles.MyConnection"%>


<%

String fName = (String)request.getParameter("fname");
String lName = (String)request.getParameter("lname");

String result = MyConnection.userExist(fName, lName);
response.getWriter().flush();
response.getWriter().write(result);

%>