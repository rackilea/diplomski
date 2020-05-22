...
<c:if test="${not empty loggedInUser}">
    <p>You're still logged in.</p>
</c:if>
<c:if test="${empty loggedInUser}">
    <p>You're not logged in!</p>
</c:if>
...