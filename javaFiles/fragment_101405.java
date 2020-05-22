<c:forEach var="sprav" items="${spravList}">
        <tr>
            <td>
                ${sprav.id}
            </td>
            <td>
                <c:forEach items="${sprav.map}" var="entry">
                  Key = ${entry.key}, value = ${entry.value}<br>
                </c:forEach> 
            </td>
        </tr>
    </c:forEach>