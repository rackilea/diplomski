<tbody>
    <c:forEach var="map" items="${mapList}">
        <tr>
            <td width="5%">${map.get("ROW_NUM")}</td>
            <td width="10%">${map.get("PAY_CODE")}</td>
            <td width="15%">${map.get("PAY_CODE_DESC")}</td>
            <td width="10%">${map.get("AMOUNT")}</td>
        </tr>
    </c:forEach>
</tbody>