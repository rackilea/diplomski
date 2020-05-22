<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

var Locale = [];
<c:forEach var="key" items="${keys}">
Locale["<spring:message text='${key}' javaScriptEscape='true'/>"] = "<spring:message code='${key}' javaScriptEscape='true' />";
</c:forEach>