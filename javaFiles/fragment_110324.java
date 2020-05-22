<#list gfpVb.chaines as key, value> 
  <td>
    <strong>${key}</strong>                                
  </td>
  <#list value?split(';') as columnValue>
    <td>
      <strong>${columnValue}</strong>
    </td>
  </#list>
</#list>