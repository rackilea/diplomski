<table>
<c:forEach var="user" items="${list_users}">  
<tr><td>  
 <c:out value="${user.name}"/><br>
 <c:out value="${user.surname}"/><br>
<hr>
</td></tr>
</c:foreach>
</table>