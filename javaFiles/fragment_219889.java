<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${true == sessionScope.userallowed}">
<ul>
    <li><a href="servletName">MyfirstSubmenu</a></li>
    <li><a href="servletName1">MyfirstSubmenu1</a></li>
</ul>
</c:if>