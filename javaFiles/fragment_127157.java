<c:if test="${loggedIn}">
    Congratulations: you're now logged in.
</c:if>
<c:if test="${!loggedIn}">
    Sorry. Wrong user name or password
</c:if>