<c:forEach var="myMap" items="${emp1.tlnameMap}">
  <c:out value=" key is ${myMap.key}" />
  <c:forEach var="mapValue" items="${myMap.value}" varStatus="count">
        <c:out value=" value ${count.index} is ${mapValue}" />
  </c:forEach>
</c:forEach