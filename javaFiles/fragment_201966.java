<c:choose>
<c:when test="${not empty  errors}">
    <div class="error">
    <c:forEach items="${errors}" var="err">
        ${err.defaultMessage}
        <br/>
    </c:forEach>
    </div>
</c:when>
</c:choose>