<select name="condition">
  <option value="">&nbsp;</option>
  <c:forEach items="${conditions}" var="condition">
    <option value="${condition.code}" ${condition.code == param.condition ? 'selected' : ''}>${condition.code}:&nbsp;${condition.description}</option>
  </c:forEach>
</select>