<th:block th:each="role : ${roles}">
    <input type="checkbox"
           name="newRoles"
           th:checked="${role.checked}"
           th:value="${role.id}"/>
    <label th:text="${role.authority}"></label>
</th:block>