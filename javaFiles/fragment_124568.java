<form:select id="_${sec_field}_id" path="${sec_field}" disabled="${disabled}">                         
   <c:if test="${not required}">                                
     <formExtension:nulloption value="null"></formExtension:nulloption>
   </c:if>
   <form:options items="${items}" itemValue="${fn:escapeXml(itemValue)}" itemLabel="${sec_itemLabel}"/>
</form:select>