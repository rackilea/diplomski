<c:forEach items="${statList1}" var="stat">
  <tr class="editField">
    <td>
      <c:out value="${stat[0]}" />
    </td>
    <td>
      <c:out value="${stat[1]}" />
    </td>
    <td>
      <c:out value="${stat[2]}" />
    </td>
    <td>
      <c:out value="${stat[3]}" />
    </td>
    <td>
      <c:out value="${stat[4]}" />
    </td>
  </tr>
</c:forEach>