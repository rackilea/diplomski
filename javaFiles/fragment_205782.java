<ul class="dropdown-menu dropdown-user">
<c:if test="${uaccount == 'admin'}">
   <li><a href="users_info">user info</a></li>              
</c:if>
<li><a href="${pageContext.request.contextPath}/logout">logout</a></li>
</ul>