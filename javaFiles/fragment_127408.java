<c:forEach var="myItem" items="${myCollection}">
alert('<c:out value="${myItem.id}">')
<c:if test="${myItem.id == 0}"> 
   alert("zero"); 
</c:if>
</c:forEach>