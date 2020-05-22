...
<input type="text" name="${row.dataElementJavaName}" 
           maxlength="${row.dataElementSize}" 
           size="60" 
           value="${row.dataElementValue}"
           onkeyup="javascript:enableSave()" 
           onkeypress="return letternumber(event,'c')" 
           <c:if test="${model.readonlyStatus=='true'}">disabled</c:if> 
/>  
...