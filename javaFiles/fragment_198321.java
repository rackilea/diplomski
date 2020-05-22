<c:forEach items="${userList}" var="currentUser" varStatus="index">
    <form:form method="post" action = "edit" commandName="user">
    <tr>
        <td><form:input path = "login" value = "${currentUser.login}" /></td>
        <td><form:input path = "password" value = "${currentUser.password}" /></td>
        <td><form:input path = "smtpServer" value = "${currentUser.smtpServer}" /></td>
        <td><form:input path = "popServer" value = "${currentUser.popServer}" /></td>
            <form:hidden path="id" value=""/>
        <td>
            <a href="delete/${user.id}"><spring:message code="label.delete" /></a>
        </td>
    </tr>
       <input type="submit" value = "edit"> 
    </form:form>
</c:forEach>