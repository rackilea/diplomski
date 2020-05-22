<c:forEach var="imageURL" items="${actionBean.imageURLs}" varStatus="rowCounter">
    <c:if test="${rowCounter.index mod 3 eq 0}">
        <tr>
    </c:if>
    <td>stuff</td>
    <c:if test="${(rowCounter.index+1) mod 3 eq 0 or rowCounter.last}">
        </tr>
    </c:if>
</c:forEach>