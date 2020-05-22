<c:forEach items="${location.ftpEvents}" var="item">
    <tr><td><form:input path="item.hostName" size="30" maxlength="200"/></td>
    <td><form:input path="item.directory" size="30" maxlength="200"/></td>
    <td><form:input path="item.userName" size="20" maxlength="20"/></td>
    <td><form:input path="item.password" size="20" maxlength="20"/></td>
    </tr>
 </c:forEach>