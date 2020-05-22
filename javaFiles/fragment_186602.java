<table>
    <span th:each="b: ${model.books}">
        <td>
            <tr th:each="a: ${b.authors}">
                <p th:text="${a.name}"></p>
            </tr>
        <td>
    </span>
</table>