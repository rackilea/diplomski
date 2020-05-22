<form action="#" th:action="@{/greeting}" th:object="${greeting}" method="post">
    <p>Id: <input type="text" th:field="*{id}" /></p>
    <p>Message: <input type="text" th:field="*{content}" /></p>
    <input type="hidden" th:field="*{hour}" />
    <input type="hidden" th:field="*{longNumber}" />
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>