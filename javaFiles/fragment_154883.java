<c:choose>
        <c:when test="${not empty sessionScope.username}">
            // all the codes goes here
        </c:when>
        <c:otherwise>
            <h1>Please Login First.</h1>
        </c:otherwise>
</c:choose>