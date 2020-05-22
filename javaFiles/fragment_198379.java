<div th:if="${not #lists.isEmpty(counts)}">
    <h2>Counts List</h2>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <tr th:each="count : ${counts}">
            <td th:text="${count.id}"></td>
            <td th:text="${count.name}"></td>
        </tr>
    </table>
</div>