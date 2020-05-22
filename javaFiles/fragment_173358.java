<script language="javascript">
     function getStates(selectedCountry)
     {
    window.location.href='/getStates?country='+selectedCountry; 
     }

     </script>

<form:select path="country" id="country">
    <form:option value="">Select Country</form:option>
    <form:options items="${countries}" itemValue="countryCode" itemLabel 
     = "countryName" onchange="javascript:getStates(this.value)"/>
</form:select>

    <form:select path="state" id="state">
        <form:option value="">Select State</form:option>
<c:if test="${not empty states}" >
        <form:options items="${states}" itemValue="stateCode" itemLabel 
         = "stateName"/>
</c:if>
    </form:select>