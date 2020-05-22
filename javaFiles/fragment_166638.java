<c:forEach var="entry" items="${perCat}">
    <c:out value="${entry.key}"></c:out>
    <c:forEach var="valueEntry" items="${entry.value}">
        <c:out value="${valueEntry.key}" /> 
        <c:out value="${valueEntry.value}" />
    </c:forEach>
</c:forEach>