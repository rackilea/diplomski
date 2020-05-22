<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sample Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <c:choose>
        <c:when test="${pageContext.request.isUserInRole('admin')}">
            <p>Content for admin.<p>
        </c:when>
        <c:when test=${pageContext.request.isUserInRole('someRole')}">
            <p>Some content here</p>
        <c:when>
        <c:otherwise>
            <p>Another Content</p>
        </c:otherwise>
    </c:choose>
</body>
</html>