<form:select  name="precipant" path="precipant" id="precipant" onchange="showpopup(this.options[this.selectedIndex].value,this.form,'Newprecipant?#login_form3');">
 <form:option value="" selected="selected">--Please Select--</form:option> 

    <c:forEach items="${precipitantdroplist}" var="listop">
            <c:if test="${listop.precipitants eq listop.precipant}">
                <option value="${listop.precipitants}">${listop.precipitants}</option>
            </c:if>
            <c:if test="${listop.precipitants != listop.precipant}">
                <option value="${listop.precipitants}">${listop.precipitants}</option>
            </c:if>
    </c:forEach>

    <form:option value="">-----------------------</form:option>
    <form:option value="Add New">Add New</form:option>
    <form:option value="removeP">Remove</form:option>
</form:select>