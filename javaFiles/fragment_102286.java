<c:forEach var="customObject" items="${vobject.getCustomObjectList}">
    <td>
<input type="hidden" name="customObjectList" value= <c:out value="${customObject.getField()}" /> />

    </td>
</c:forEach>