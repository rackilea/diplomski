<% java.util.List x = new path.to.java.class.method(); %>
 <c:set var="n" value="<%=x%>"/>

 <c:forEach items="${n}" var="element">
      <c:out value="${element.getId()}"/>
 </c:forEach>