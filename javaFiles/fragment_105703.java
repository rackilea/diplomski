<form:form modelAttribute="myForm" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="person.firstName">First Name:</form:label></td>
            <td><form:input path="person.firstName"/></td>
            <td><form:errors path="person.firstName"/>gfgf</td>
        </tr>
        <tr>
            <td><form:label path="passport.country_issue">Passport:</form:label></td>
            <td><form:input path="passport.country_issue"/></td>
            <td><form:errors path="passport.country_issue"/></td>
        <tr/>
    </table>
</form>