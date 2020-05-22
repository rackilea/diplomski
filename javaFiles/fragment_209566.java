<nested:iterate id="currentError" property="wizard.errors" type="java.lang.String" indexId="counter">
    <tr>
        <td valign="top" class="wizardErrorText" width="2%">
            &gt;
        </td>
        <td class="wizardErrorText">
            <span errorId="<bean:write name="wizard" property="erroredInputs[counter]" />">
                <bean:write name="currentError"/>  
            </span>
        </td>
    </tr>
</nested:iterate>