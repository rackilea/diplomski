...
<select id="${fieldHtmlId}" name="${field.name}" tabindex="0"
     <#if field.description??>title="${field.description}"</#if>
</select>
...
<script type="text/javascript">//<![CDATA[
YAHOO.util.Event.onContentReady("${fieldHtmlId}", function ()
{
    Alfresco.util.Ajax.jsonGet({
        url: encodeURI(Alfresco.constants.PROXY_URI + '/myserviceuri'),
        successCallback:
        {
            fn: function loadWebscript_successCallback(response, config)
            {
                var obj = eval('(' + response.serverResponse.responseText + ')');
                if (obj)
                {
                    for (i = 0; i < obj.length; i++) {
                            var newOption = document.createElement('option');
                            newOption.value = obj[i].id;
                            newOption.text = obj[i].name;
                            YAHOO.util.Dom.get("${fieldHtmlId}").options.add(newOption);
                    }
                }
            }
        }
    });

}, this);
//]]></script>