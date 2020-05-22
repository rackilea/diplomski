<c:forEach var="emp" items="${empdetails}">
    <tr>
        <td><c:out value="${emp.id}" /></td>
        <td><c:out value="${emp.firstName}" /></td>
        <td><c:out value="${emp.lastName}" /></td>
        <!--- etc etc data -->      
    </tr>
</c:forEach>