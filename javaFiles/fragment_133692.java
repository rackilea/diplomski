<c:url var="nextUrl" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'page'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="page" value="${some calculation}" />
</c:url>