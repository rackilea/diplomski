<%@ page language="java" import="java.sql.*,java.util.*,java.text.*" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String DRIVER = "com.mysql.jdbc.Driver";

    ArrayList<String> tables = new ArrayList<String>();

    Class.forName(DRIVER).newInstance();
    Connection con = null;
    ResultSet rst = null;
    Statement stmt = null;
    Connection con2 = null;
    ResultSet rst2 = null;
    Statement stmt2 = null;     
    try {
        String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        con = DriverManager.getConnection(url);
        stmt = con.createStatement();
        rst = stmt.executeQuery("select table_name from information_schema.tables where table_schema='mydb' and table_name like '%_work' ");

        con2 = DriverManager.getConnection(url);
        stmt2 = con2.createStatement();
        String table_name = "table_name";

        //Insert into tables...
        while (rst.next()) {
            tables.add(rst.getString("table_name"));    
        }

        boolean first = true;
        StringBuilder query2 = new StringBuilder();

        //...then iterate over
        for (String table : tables) {           
            if(first) {
              query2.append(" select distinct id from ");
              first = false;
            }else {
              query2.append(" UNION ALL select distinct id from ");
            }
            query2.append('\'').append(table).append('\'');
        }

        //Put variable inside context to access it in jstl
        pageContext.setAttribute("query", query2.toString());
        pageContext.setAttribute("tables", tables);

        rst.close();
        stmt.close();
        con.close();
    } catch (SQLException se) {
        //System.out.println("SQL statement is not executed!");
        se.printStackTrace();
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style>
            table, th, td {
               border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div>
            <span>Query : ${query}</span>
        </div>
        <table>
            <tr>
              <th>Table name</th>
            </tr>
            <c:forEach var="table" items="${tables}"> 
              <tr>
                <td>
                    <c:out value = "${table}"/>
                </td>
              </tr>
            </c:forEach>
        </table>
    </body>
</html>