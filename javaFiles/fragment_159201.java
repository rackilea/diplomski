<c:forEach items="${A}" varStatus="status">
   …

   <form:input path="A[${status.index }].attribute"/>
   …

</c:forEach>