<%@ attribute name="url" required="true" %>
<%@ attribute name="paramMap" required="false" type="java.util.Map"%>
<%@ tag trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty paramMap}">
    <c:import url="${url}"/>
</c:if>
<c:if test="${!empty paramMap}">
    <c:set var="paramString" value=""/>
    <c:forEach var="entry" items="${paramMap}">
        <c:if test="${!empty paramString}">
            <c:set var="paramString">${paramString}&</c:set>
        </c:if>
        <c:set var="paramString">${paramString}<c:out value="${entry.key}"/>=<c:out value="${entry.value}"/></c:set>
    </c:forEach>
    <c:url value="${url}?${paramString}" var="fullUrl"/>
    <c:import url="${fullUrl}"/>
</c:if>