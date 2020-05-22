<logic:present name="accounts">
    <logic:iterate id="account" name="accounts" indexId="index">
        <c:if test="${index == 0}">
            <bean:write name="account.bic" />
        </c:if>
    </logic:iterate>
</logic:present>