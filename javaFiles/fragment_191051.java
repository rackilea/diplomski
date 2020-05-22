<form:form commandName="preferencesDto">
    <c:forEach items="${languagesAvailable}" var="item">
        <form:checkbox path="languages" value="${item}"/>${item.code6391}
    </c:forEach>
    <input type="submit" value="Save"/>
</form:form>