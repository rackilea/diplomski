<c:forEach items="${orders}" var="order" varStatus="status">
<tr>
    <td><B>ID</B></td>
    <td>${order.id}</td>
</tr>
.
.
.
<tr>
    <td>Price</td>
    <td>${prices.get(status.index)}</td>
</tr>
</c:forEach>