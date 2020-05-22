<form:form commandName="dateRange">
...
    <select name="fyForDR" id="fyForDR" class='discretFont' style='margin-left:10px;margin-right:10px;'>
            <option value="" selected='selected'>Fiscal Year</option>
            <option value="2011" <c:if test="${fyForDR == '2011'}">selected="selected"</c:if> >FY11</option>
            <option value="2010" <c:if test="${fyForDR == '2010'}">selected="selected"</c:if> >FY10</option>
            <option value="2009" <c:if test="${fyForDR == '2009'}">selected="selected"</c:if> >FY09</option>
            <option value="2008" <c:if test="${fyForDR == '2008'}">selected="selected"</c:if> >FY08</option>
            <option value="2007" <c:if test="${fyForDR == '2007'}">selected="selected"</c:if> >FY07</option>
            <option value="2006" <c:if test="${fyForDR == '2006'}">selected="selected"</c:if> >FY06</option>
        </select>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({
                elementId: "fyForDR",
                event: "onchange",
                formId:"dateRange",
                params: {fragments:"body", _eventId: "setFy"}
            }));
        </script>
...
</form:form>