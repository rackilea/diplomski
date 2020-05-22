<select name="brand" size="1">
  <c:forEach var="brand" items="${brands}">
    <option <c:out value="${brand == param.brand ? 'selected' : ''}" />>
      <c:out value="${brand}" />
    </option>
  </c:forEach>
</select>