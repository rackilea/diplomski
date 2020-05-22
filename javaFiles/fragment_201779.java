<table>
<c:forEach items="${claimstable}" var="claim">
<tr>
<td>${claim.belnr}</td>
<td>${claim.bktxt}</td>
<td>${claim.zuonr}</td>
<td>${claim.blart}</td>
</tr>
</c:forEach>
</table>