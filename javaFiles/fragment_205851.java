...
        <form:select multiple="true" path="userRoles" itemValue="role">
            <c:forEach items="${roles}" var="role">
                <c:set var="selected" value="false" />
                <c:forEach items="${newUser.userRoles}" var="userRole">
                    <c:if test="${fn:containsIgnoreCase(userRole, role)}">
                        <form:option value="${role}" selected="true"/>
                        <c:set var="selected" value="true" />
                    </c:if>
                </c:forEach>
                <c:if test="${selected eq false}">
                    <form:option value="${role}"/>
                </c:if>
            </c:forEach>
        </form:select>
        ...