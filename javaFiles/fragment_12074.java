<th:block th:each = "record : ${records}">
  <tr>
    <td><input type="checkbox" th:field="*{selected}"/></td>
    <td><input type="text" th:field="*{id}"/></td>
    <td><input type="text" th:field="*{name}"/></td>
    <td><input type="text" th:field="*{phone}"/></td>
  </tr>
</th:block>