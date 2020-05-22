<table>
    <c:forEach items="${entries}" var="entry">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><c:out value="${entry.value}" /></td>
        </tr>
    </c:forEach>
</table>