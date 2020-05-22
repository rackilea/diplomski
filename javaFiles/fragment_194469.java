<c:forEach var="o" items="${stdobj}">
    <tr>
        <td><c:out value="${o.id}"/></td>
        <td><c:out value="${o.name}"/></td>
        <td><c:out value="${o.age}"/></td>   
    </tr>
</c:forEach>