<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 java.util.ArrayList list = new java.util.ArrayList();
 list.add("$0.00 to $1,000,000.00");
 list.add("$1,000,000.00 to $1,000,000,000.00");
 request.setAttribute("list", list);
%>

<h1>Iterating over ArrayList</h1>
<ul>
 <c:forEach items="${list}" var="value">
  <li><c:out value="${value}"/></li>
 </c:forEach>
</ul>

<h1>Iterating over first element of ArrayList</h1>
<ul>
 <c:forEach items="${list[0]}" var="value">
  <li><c:out value="${value}"/></li>
 </c:forEach>
</ul>