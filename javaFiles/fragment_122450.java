<c:if test="${not empty param.model}">
  <c:if test="${empty param.color}">
    <c:set var="colors" value="${connector.getColors(param.brand, param.model)}"
           scope="session" />
  </c:if>
  <form method="post" action="OrderConfirmation.jsp">
    <label>Color<br/>
    <select name="color" size="1">
      <c:forEach var="color" items="${colors}">
        <option><c:out value="${color}"/></option>
      </c:forEach>
    </select>
    </label><br/>
    <input type="hidden" name="brand" value="${param.brand}"/><br/>
    <input type="hidden" name="model" value="${param.model}"/><br/>
    <br/>
    <br/>
    Next step<br/>
    <input type="submit" value="Continue"/>
  </form>
</c:if>