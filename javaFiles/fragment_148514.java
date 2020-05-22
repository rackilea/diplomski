<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tomcat Version</title>
    </head>
    <body>
        <h2>Tomcat Version</h2>
        <pre><%=pageContext.getServletContext().getServerInfo()%></pre>
        <h2>Servlet Version</h2>
        <pre><%=pageContext.getServletContext().getMajorVersion()%>.<%=pageContext.getServletContext().getMinorVersion()%></pre>
    </body>
</html>