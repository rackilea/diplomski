<table>
  <c:forEach items="${list}" var="row" varStatus="rowCounter">
    <c:if test="${rowCounter.count % 5 == 1}">
      <tr>
    </c:if>
    <td><img src="${row.imageUrl}"/><br/>Table ${rowCounter.count}</td>
    <c:if test="${rowCounter.count % 5 == 0||rowCounter.count == fn:length(values)}">
      </tr>
    </c:if>
  </c:forEach >
</table>