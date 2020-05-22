<c:forEach items="${allFestivals}" var="festival">
    <tr>      
        <td>${festival.festivalName}</td>
        <td>${festival.location}</td>
        <td>${festival.startDate}</td>
        <td>${festival.endDate}</td>
        <td>${festival.URL}</td>  
    </tr>
</c:forEach>