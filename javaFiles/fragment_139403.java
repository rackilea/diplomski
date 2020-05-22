<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${operation == 'CREATE'}">
    <c:if test="${city != null}">
          CITY <c:out value="${city.city}" /> ADDED
    </c:if>
    <c:if test="${operation == 'UPDATE'}">
          CITY <c:out value="${city.city}" /> UPDATED
    </c:if>
</c:if>