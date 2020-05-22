<%@page import="java.sql.*"%>
<%
try {
String name=request.getParameter("name");
String address=request.getParameter("address");
Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", youruser, yourpassword);
           Statement st=cn.createStatement();
           int i = st.executeUpdate("insert into user(name,address) values('"+name+"','"+address+"')");
           out.println("Data is inserted successfully");
           st.close();
           cn.close();
} catch (Exception e) {
   out.println(e.getMessage());
}
%>