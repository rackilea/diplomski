<rich:dataTable value="#{pesquisaBean.uriByTitle}" var="uri">
    <rich:column>
        <f:facet name="header">URI</f:facet>
        #{uri}
    </rich:column>
 </rich:dataTable>