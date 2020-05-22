<c:if test="${not empty list}">
  <c:forEach var="ob" items="${list}">
     <tr>
       <td><c:out value="${ob.name}"/></td>
       <td><c:out value="${ob.dob}"/></td>
       <td><c:out value="${ob.balance}"/></td>
    </tr>
  </c:forEach>
</c:if>