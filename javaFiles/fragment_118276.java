<%@ attribute name="timestamp" required="true" type="java.sql.Timestamp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${not empty timestamp}">
    <span title="${timestamp}"><fmt:formatDate value="${timestamp}"
            pattern="MM/dd/yyyy HH:mm" /></span>
</c:if>