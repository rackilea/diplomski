<sql:query dataSource="${dbsource}" var="result">
    SELECT COUNT(*) as row_count FROM employee WHERE emp_id = ?;
    <sql:param value="${param.userid}" />
</sql:query>

<c:choose>
    <c:when test="${result.rows[0].row_count == 0}">
        <sql:update>...</sql:update>
    </c:when>
    <c:otherwise>
        Employee data already exists!
    </c:otherwise>
</c:choose>