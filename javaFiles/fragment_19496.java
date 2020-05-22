<li>
   ${node.value}
   <c:if test="${fn:length(node.children) gt 0}">
      <ul>
         <c:forEach var="node" items="${node.children}">
           <c:set var="node" value="${node}" scope="request" />
           <jsp:include page="node.jsp" />
         </c:forEach>
      </ul>
   </c:if>
</li>