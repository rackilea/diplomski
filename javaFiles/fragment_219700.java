<page>
    <!-- this sets the accessKey variable with the query parameter -->
    <param name="accessKey" value="#{myAuthenticator.accessKey}" />

    <!-- this invokes our authentication action -->
    <action execute="#{myAuthenticator.doAuth}" />

    <!-- navigation rules, these determine what to do if auth is ok or fails -->
    <navigation from-action="#{myAuthenticator.doAuth}">
        <rule if-outcome="ko">
            <redirect view-id="/error.xhtml">
                <message severity="ERROR">Invalid Authentication Key</message>
            </redirect>
        </rule>
        <rule if-outcome="ok">
            <redirect view-id="/home.xhtml">
                <message severity="INFO">Welcome!</message>
            </redirect>
        </rule>
    </navigation>
</page>