<select name='role'>
    <option value="${selected}" selected>${selected}</option>
    <c:forEach items="${roles}" var="role">
        <c:if test="${role != selected}">
            <option value="${role}">${role}</option>
        </c:if>
    </c:forEach>
</select>