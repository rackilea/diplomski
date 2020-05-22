<#macro dumpFoo foo>
  ${foo.bar}
  <#list foo.foos as childFoo>
    <@dumpFoo childFoo />
  </#list>
</#macro>

<@dumpFoo myFoo />