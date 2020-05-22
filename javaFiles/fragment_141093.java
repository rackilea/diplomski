<#list items as item>
 * <#if something><#--
       -->${something?right_pad(10)}<#--
   --><#else><#--
       ${something_else?right_pad(10)}<#--
   --></#if><#--
   --><#if another_thing><#--
       -->${more_data?right_pad(20)}<#--
   --><#else><#--
       -->${even_more_data?right_pad(20)}<#--
   --></#if>
</#list>