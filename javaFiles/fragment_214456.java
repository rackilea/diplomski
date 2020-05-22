<#list section.field?chunk(2) as row>
  <#list row as field>
    <div class="col${field_index + 1}">
      ${field.@label}: <input type="text"/>
    </div>
  </#list>
</#list>