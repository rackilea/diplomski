<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                   "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test DataSource Connection</title>
  </head>
<body>
<h1>Connecting to Pooled Database</h1>  
<%
    InitialContext ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("MyDataSource");
    Connection connection = ds.getConnection();

    if (connection == null) {
        throw new SQLException("Error establishing connection!");
    }

    PreparedStatement stmt = null;
    ResultSet result = null;
    stmt = connection.prepareStatement("{call StoredProcedure(?,?)}");
    stmt.setString(1, "1");
    stmt.setString(2, "2");
    result = stmt.executeQuery();

    while (result.next()) {
        out.print(result.getString(1) + "<br>");
    }
%>

<h2>DataSource Working!</h2>
</body>
</html>