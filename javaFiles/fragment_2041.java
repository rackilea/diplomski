<div id="settingsdiv" style="width:350px; height:400px; position:absolute;  background-color:r; top:20px; left:1px">

    <div id="settingsHashMap" style="width:1050px; height:400px; position:absolute;  background-color:r; top:20px; left:1px">

        <h:form id="form" >
            <p:growl id="growl" showDetail="true" sticky="true" />

            <h:commandButton value="Show next #{GlassfishLogFileController.pageSize} lines" 
                                 action="#{GlassfishLogFileController.actionNextPage}" />
            <h:commandButton value="Clear offset" 
                                 action="#{GlassfishLogFileController.actionClearOffset}" />
            <h:inputTextarea rows="30" cols="1000" value="#{GlassfishLogFileController.data}" />   
        </h:form>                    
    </div> 

</div>