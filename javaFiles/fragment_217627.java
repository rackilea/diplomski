<select class="form-control" name="menu" id="menu">
    <c:forEach var="menu" items="${menu}">
        <c:choose>
            <c:when test="${menu.fbMenuId == order.fbMenuId}">
                <option value="${order.fbMenuId}" selected>${order.fbMenuName}</option> 
            </c:when>
            <c:otherwise>
                <option value="${menu.fbMenuId}">${menu.fbMenuName} </option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>