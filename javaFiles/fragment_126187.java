<c:forEach var="a" items="${list}" varStatus="it">
 <c:if test="${it.index%10==0}">
  <tr>
 </c:if>
 <td>${a}</td>
 <c:if test="${it.index%10==9}">
  </tr>
 </c:if>
</c:forEach>