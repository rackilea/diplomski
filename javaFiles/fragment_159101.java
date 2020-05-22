<select name="itemCode">
   <c:forEach items="${list}" var="value">
     <option value="${value}">
      ${value}
     </option>
   </c:forEach>
  </select>