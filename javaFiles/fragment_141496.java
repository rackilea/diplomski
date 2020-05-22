<tr id="myTableRow">
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
                    ${framework}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach>
                </td>

                <td>
                    <spring:url value="/users/${user.id}" var="userUrl"/>
                    <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>

                    <spring:url value="/users/${user.id}/delete" var="deleteUrl"/>
                    <button class="btn btn-danger" onclick="removeUser('${deleteUrl}')">Delete</button>

                    <spring:url value="/users/${user.id}/update" var="userUpdate"/>
                    <button class="btn btn-info" onclick="location.href='${userUpdate}'">Update</button>
                </td>
            </tr>