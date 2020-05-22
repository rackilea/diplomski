<table border="1">
    <c:forEach items="${xml}" var="itemMap">
        <c:forEach items="${itemMap}" var="mapEntry">
        <tr>
            <td>
                <c:choose>
                    <c:when test="${mapEntry.key == 'name'}">
                        <c:out value="Name:" />
                    </c:when>
                    <c:when test="${mapEntry.key == 'catVal'}">
                        <c:out value="Cat value:" />
                    </c:when>
                    <c:when test="${mapEntry.key == 'catStat'}">
                        <c:out value="Cat status:" /> 
                    </c:when>
                </c:choose>
            </td>
            <td>
                ${mapEntry.value}
            </td>
        </tr>
        </c:forEach>
    </c:forEach>
</table>