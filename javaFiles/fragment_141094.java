<#list items as item>
 * <#if something><#rt>
       ${something?right_pad(10)}<#lt><#rt>
   <#else><#lt><#rt>
       ${something_else?right_pad(10)}<#lt><#rt>
   </#if><#lt><#rt>
   <#if another_thing><#lt><#rt>
       ${more_data?right_pad(20)}<#lt><#rt>
   <#else><#lt><#rt>
       ${even_more_data?right_pad(20)}<#lt><#rt>
   </#if><#lt>
</#list>