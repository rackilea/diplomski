<c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        ${user.id}
                    </td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
                        ${framework}
                        <c:if test="${not loop.last}">,</c:if>
                        </c:forEach></td>
                    <td>
                   </tr>
            </c:forEach>