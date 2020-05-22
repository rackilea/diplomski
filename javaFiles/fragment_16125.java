<c:forEach var="event" items="${pagingSet.events}">
  <tr>
    <td><c:out value="${event.name}">
        </c:out></td>
  </tr>
</c:forEach>