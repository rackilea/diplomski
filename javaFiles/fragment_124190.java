<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.pbs.web.jdbc.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PSBS - Booked Parking Spaces Tracker</title>
</head>
<%
    // "BOOKED-LIST" is attribiute name set in ControllerServlet                      
%>
<body>
    <c:forEach var="bookBean" items="${BOOKED_LIST}">
        <tr>
            <td>${bookBean.getBookID()}</td>
        </tr>
    </c:forEach>
</body> 
</html>