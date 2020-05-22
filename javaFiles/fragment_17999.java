<c:choose>
    <c:when test="${loggedIn == message.message}">
        ...
    </c:when>
    <c:otherwise>
        ...
    </c:otherwise>
</c:choose>