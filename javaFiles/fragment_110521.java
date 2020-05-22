<c:choose>
    <c:when test="${item['class'].name == 'java.lang.Integer'}">
        <fmt:formatNumber value="${item}" type="number" />
    </c:when>
    <c:when test="${item['class'].name == 'java.math.BigDecimal'}">
        <fmt:formatNumber value="${item}" type="currency" />
    </c:when>
    <c:when test="${item['class'].name == 'java.util.Date'}">
        <fmt:formatDate value="${item}" type="date" />
    </c:when>
    <c:otherwise>
        <c:out value="${item}" />
    </c:otherwise>
</c:choose>