<%@ tag body-content="empty" %> 
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="varName"    rtexprvalue="true"  required="true" type="java.lang.String"  description="Description of varName" %> 
<%@ attribute name="condition"  rtexprvalue="true"  required="true" type="java.lang.String"  description="Description of condition" %> 

<c:choose>
   <c:when test="${varName eq condition}">
      <c:out value="${fn:substring(varName, 0, 3)}
   </c:when>
   <c:otherwise>
      ${varName}
   </c:otherwise>
</c:choose>