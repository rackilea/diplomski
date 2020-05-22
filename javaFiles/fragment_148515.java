<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tomcat Version</title>
    </head>
    <body>
        <h2>Tomcat Version</h2>
        <pre>${pageContext.servletContext.serverInfo}</pre>
        <h2>Servlet Version</h2>
        <pre>${pageContext.servletContext.majorVersion}.${pageContext.servletContext.minorVersion}</pre>
    </body>
</html>