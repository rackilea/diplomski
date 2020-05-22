<c:forEach items="${products}" var="currentproduct">
        <tr>
            <td>${currentproduct.date}</td>
            <td>${currentproduct.name}</td>
        </tr>
</c:forEach>