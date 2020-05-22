<c:choose>
    <c:when test="${USER == null}">
        <form action="${pageContext.request.contextPath}/RegistrationController" method="post">
            <table>
                <tr>
                    <td>User name</td>
                    <td><input type="text" name="name" ></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="submit"></td>
                </tr>
            </table>
        </form>
    </c:when>
    <c:otherwise>
        Welcome <c:out value="${USER.name}"/>
    </c:otherwise>
</c:choose>