<c:forEach var="user" items="${users}">
    <c:out value="${user.actionTime}"/>
    <c:out value="${user.userAction}"/>
    <c:out value="${user.userIp}"/>
    <c:out value="${user.userId}"/>
</c:forEach>