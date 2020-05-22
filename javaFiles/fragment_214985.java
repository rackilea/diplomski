<c:forEach var="port" items="${container.ports}">
    <c:when test=”${not status.last}”>
        ${port.privatePort} &rarr; ${port.publicPort} //
    </c:when>
    <c:otherwise>
        ${port.privatePort} &rarr; ${port.publicPort}
    </c:otherwise>
</c:forEach>