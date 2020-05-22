<!--giving name attribute to access it in servlet-->
<select name="select">
  <c:forEach var="tempstudent" items="${select}">
  <!--passing id--> 
    <option value="${tempstudent.id}">${tempstudent.id},
      <td>${tempstudent.name}</td>
    </option>
  </c:forEach>
</select>