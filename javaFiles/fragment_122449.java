<c:if test="${not empty param.brand}">
  <c:if test="${empty param.model}">
    <c:set var="models" value="${connector.getModels(param.brand)}" scope="session" />
  </c:if>
  <form method="post">
    <label>Model<br/>
    <select name="model" size="1">
      <c:forEach var="model" items="${models}">
        <option <c:out value="${model == param.model ? 'selected' : ''}" />>
          <c:out value="${model}" />
        </option>
      </c:forEach>
    </select>
    </label><br/>
    <input type="hidden" name="brand" value="${param.brand}"/><br/>
    <input type="submit" value="Submit"/><br/>
  </form>
</c:if>