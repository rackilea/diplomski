<select name="parent">
     <c:forEach items="${parents}" var="parent">
       //      here set value="yourid"
       <option value="${parent.id}">${parent.name}
     </c:forEach>
   </select>