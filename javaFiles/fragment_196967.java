<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Test Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <%-- We iterate thru all the users --%>
    <c:forEach items="${users}" var="user">
        <!-- Outputting different user related data -->
        ...
        <!-- Now outputting the user skills -->
        <h3>User skills</h3>
        <%-- In the inside loop, we iterate thru all the available skills, stored in the ServletContext --%>
        <c:forEach items="${skills}" var="skill">
            <c:choose>
                <%-- If the user has the appropriate skill, the related checkbox will be checked. Otherwise unchecked. --%>
                <%-- Note: using skill as a key in the map of user skills --%>
                <c:when test="${user.skills[skill] == true}">
                    <input type="checkbox" name="chkSkills" value="${skill}" checked="checked">${skill}&nbsp;
                </c:when>
                <c:otherwise>
                    <input type="checkbox" name="chkSkills" value="${skill}">${skill}&nbsp;
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:forEach>
</body>
</html>