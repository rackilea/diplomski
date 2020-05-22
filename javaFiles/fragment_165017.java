<c:forEach items="${test.dataList}" var="m3">
    <tr>
        <th>${m3.hostName}</th>
        <td>${m3.totalCall}</td>
        <td>${m3.timeoutCount}
<c:if test="${m3.totalCall > 0}">
   <c:out value="%"/>
</c:if>
</td>
    </tr>
</c:forEach>