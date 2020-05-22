<c:forEach var="question" items="${questions}">
    <tr>  
        <td><c:out value="${question.label}" /></td>
        <td><c:out value="${question.option1}"/></td>
        ...
    </tr>  
    </c:forEach>