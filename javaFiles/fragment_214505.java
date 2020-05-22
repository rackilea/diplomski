<%@page import= "com.mycompany.Number" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    pageContext.setAttribute("addResult", Number.add(7, 8));
%>
<html>
<body>
  JSP 1.x: Result is: <c:out value="${addResult}" /><br/>
  JSP 2.x: Result is: ${addResult}
</body>
</html>