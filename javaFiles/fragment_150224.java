<c:choose>
    <c:when test="${row.file_name != null}">
        Not Null
    </c:when>
    <c:otherwise>
        Null
    </c:otherwise>
</c:choose>