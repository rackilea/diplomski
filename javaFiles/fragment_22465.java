<%
    getPipelineDictionary().put("current_date",new Date());
%>
<isif condition="#(Product:QLC_ValidTo:getTime > current_date:getTime)#">                        
    <span class="items-in-stock align-left">
        <isinclude template="product/inc/CC_StockStatus"/>
    </span>
</isif>