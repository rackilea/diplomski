<c:forEach var="i" begin="1" end="${toLvvt}" step="1">
  <c:set var="mapKey" value="${to.id}-${record.rId}-${record.opjakso}" />
  <c:set var="property" value="v${i}s" />
  <c:if test="${MyMap[mapKey][property]}">
    ..
  </c:if>
</c:forEach>