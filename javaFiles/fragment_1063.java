<tbody>
    <c:forEach var="map" items="${mapList}">
        <tr>
            <c:forEach var="mapEntry" items="${map}">
                <td>${mapEntry.value}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</tbody>