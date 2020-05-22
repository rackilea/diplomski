<c:forEach var="entry" items="${multiMap}">
    <br/>-> Key: <c:out value="${entry.key}"/>
    <br/>-> Values for this key:
    <c:forEach var="currentValue" items="${entry.value}">
        <br/>|---> value: <c:out value="${currentValue}"/>
    </c:forEach>
</c:forEach>