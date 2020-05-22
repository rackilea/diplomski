<c:forEach items="${listMapView.listMap}" var="listMapview" varStatus="status">
    <tr>
        <td>${listMapview.key}</td>
        <td>${listMapview.value}</td>
    </tr>
</c:forEach>