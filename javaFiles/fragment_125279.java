<c:forEach var="lists" items="${list}">
    <tr>
      <td><c:out value="${lists.firstName}" /><td>
      <td><c:out value="${lists.lastName}" /><td>
    </tr>
  </c:forEach>