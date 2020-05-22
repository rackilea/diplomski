<apex:form>
    <apex:pageBlock>
        <apex:inputField value="{!customObject__c.Date__c}"/>
        <apex:inputField value="{!customObject__c".Time__c}"/>
        <apex:commandButton value="Save" action="{!save}"/>
    </apex:pageBlock>
</apex:form>