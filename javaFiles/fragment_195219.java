<c:forEach var="record" items="${recordset}">
    <c:out value="${record.master.empcode}" />
    <c:out value="${record.master.empname}" />
    <c:out value="${record.master.dept}" />
    <c:out value="${record.daterange.ddate}" />
</c:forEach>