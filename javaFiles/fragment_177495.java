<c:forEach items="${months}" var="month">
  <c:choose>
    <c:when test="${month.value == currentMonth}">
        <option value="${month.value}" selected>${month.value}</option>
    </c:when>
    <c:otherwise>
        <option value="${month.value}">${month.value}</option>
    </c:otherwise>
  </c:choose>
</c:forEach>