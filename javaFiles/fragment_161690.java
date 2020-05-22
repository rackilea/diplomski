<rich:dataTable value="#{dataProviderBean.aoRequests}" var="item">
    <f:facet name="noData">No messages are available.</f:facet>
    ...
    <rich:column>
        <f:facet name="header">Image data</f:facet>
        <rich:list value="#{item.imageContents}" var="content">
            <a4j:mediaOutput element="img" cacheable="false" session="false"
                createContent="#{imageBean.paint}" value="#{content.id}" />
        </rich:list>
    </rich:column>
</rich:dataTable>