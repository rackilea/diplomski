<t:dataTable var="person" value="#{bean.people}" rowIndexVar="index"
             newspaperOrientation="horizontal" newspaperColumns="2">
    <h:column>
        <h:outputText value="#{index + 1}"/>
    </h:column>
    <h:column>
        <h:outputText value="#{person}"/>
    </h:column>
</t:dataTable>