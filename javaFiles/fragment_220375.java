<c:forEach items="${requestScope.validationResults}" var="mapEntry" varStatus="index">
    <c:if test="${mapEntry.key == 'userName'}">
        <tr>
            <td>${mapEntry.value.details}</td>
        </tr>
    </c:if>
</c:forEach>