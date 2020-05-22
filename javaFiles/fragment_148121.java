<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>        
<c:choose>
  <c:when test='${ fn:toLowerCase(param.action) eq "edit" }'>
    ...
  </c:when>
  <c:otherwise>
    ...
  </c:otherwise>
</c:choose>