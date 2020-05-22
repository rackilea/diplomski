<table>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.make}</td>
            <td>${car.model}</td>
            <td>${car.type}</td>
            <td>${car.color}</td>
            <td>${car.price}</td>
        </tr>
    </c:forEach>
</table>