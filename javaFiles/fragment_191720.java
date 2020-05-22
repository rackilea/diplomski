<%@ codebehind="menu.java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
       <c:forEach var="menu" value="${menuItem}">
           <li><c:out value="${menu}"/></li>
       </c:forEach>
</ul>