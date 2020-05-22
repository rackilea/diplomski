<c:forEach items="${text}" var="item">
    <tr>
    <td><c:out value="${item.getKey()}" /></td>
      <td><c:out value="${item.getValue()}" /></td>
    </tr>
  </c:forEach>