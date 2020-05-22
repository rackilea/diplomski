<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<ul>
  <c:forEach var="mediaFile" items="${mediaFiles}">
    <li><c:out value="${mediaFile.name}"/></li>
  </c:forEach>
</ul>
</body>
</html>