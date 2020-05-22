<table>
    <th:block th:each="map : ${list}">
       <tr th:each="e : ${map}">
          <td th:text="${e.key}"></td>
          <td th:text="${e.value}"></td>
       </tr>
    </th:block>
</table>