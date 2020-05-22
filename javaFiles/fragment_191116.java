<c:forEach items="${cars}" var="car">
    <tr>      
        <td>${car.id}</td>
        <td>${car.year}</td>
        <td>${car.make}</td>
        <td>${car.model}</td>
        <td>${car.color}</td>
        <td>${car.available}</td>  
    </tr>
</c:forEach>