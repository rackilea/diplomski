<#assign DDLRecordLocalService = serviceLocator.findService("com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalService")>
<#assign records = DDLRecordLocalService.getRecords(reserved_record_set_id)>

<#if records?has_content>
    <#list records as cur_record>

       <a href="${ddmUtil.getDisplayFieldValue(themeDisplay, cur_record.getFieldValue("Documents_and_Media1422", locale), cur_record.getFieldType("Documents_and_Media1422"))}">
           ${languageUtil.format(locale, "download-x", "Documents and Media")}
       </a>
    </#list>
</#if>