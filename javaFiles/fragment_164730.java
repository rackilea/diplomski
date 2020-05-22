<form:form commandName="pojoForm" method="POST">
    <c:forEach items="${pojoForm.pojos}" varStatus="i">
        <form:input path="pojos[${i.index}].a" />
        <form:input path="pojos[${i.index}].b" />
        <form:input path="pojos[${i.index}].c" />
    </c:forEach>
</form:form>