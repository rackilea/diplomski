<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cars</title>
    <link type="text/css" rel="stylesheet" href="Styles/style.css" />
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<body>
    <h2>Car List :</h2>
    <ul>
        <c:forEach items="${requestScope.cars}" var="element"> 
            <li>${element.name }</li>
        </c:forEach>
    </ul>
</body>
</html>