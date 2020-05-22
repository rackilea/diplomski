<c:forEach items="${dc1.metrics}" var="m">
    <tr>
        <td>${m.machineName}</td>
        <td>${m.t2_95}</td>
        <td>${m.t2_99}</td>
        <td>${m.syncs}</td>
        <td>${m.syncsBehind}</td>
        <td>${m.average}</td>
    </tr>
</c:forEach>