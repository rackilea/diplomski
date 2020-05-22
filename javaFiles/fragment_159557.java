<spring:bind path = "name*">
    <c:if test="${status.error}"> 
        <tr> 
            <td> 
                <form:errors path="name*" /> 
            </td> 
        </tr> 
    </c:if> 
</spring:bind>