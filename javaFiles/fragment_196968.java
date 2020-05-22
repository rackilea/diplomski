<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Test Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <c:forEach items="${users}" var="user">
        ...
        <h3>User skills</h3>
        <c:forEach items="${skills}" var="skill">
            <%-- Note: here <c:if> tag is used right inside <input> tag --%>
            <input type="checkbox" name="chkSkills" value="${skill}" <c:if test="${user.skills[skill]}">checked="checked"</c:if>>${skill}&nbsp;
        </c:forEach>
    </c:forEach>
</body>
</html>