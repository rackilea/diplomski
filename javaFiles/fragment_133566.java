<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>fmt:dateNumber</title>
</head>
<body>
<h2>Date Format:</h2>
<c:set var="now" value="<%=new java.util.Date()%>" />

<p>Formatted Date (1): <fmt:formatDate type="time"  value="${now}" /></p>
<p>Formatted Date (2): <fmt:formatDate type="date"  value="${now}" /></p>
<p>Formatted Date (3): <fmt:formatDate type="both" value="${now}" /></p>
<p>Formatted Date (4): <fmt:formatDate type="both"  dateStyle="short" timeStyle="short"  value="${now}" /></p>
<p>Formatted Date (5): <fmt:formatDate type="both"  dateStyle="medium" timeStyle="medium" value="${now}" /></p>
<p>Formatted Date (6): <fmt:formatDate type="both"  dateStyle="long" timeStyle="long" value="${now}" /></p>
<p>Formatted Date (7): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p>

</body>
</html>