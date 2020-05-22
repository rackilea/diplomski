<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form modelAttribute="employee" method="post">
   <sf:select path="department" id="select-departments"  >
     <c:forEach items="${departments}" var="dep" varStatus="status">
       <option value="${dep.id}">${dep.name}</option>
     </c:forEach>
   </sf:select>
</sf:form>