<ui:fragment rendered="#{empty search.results}">
    <ui:include src="/WEB-INF/search#{search.type}.xhtml" />
</ui:fragment>
<ui:fragment rendered="#{not empty search.results}">
    <ui:include src="/WEB-INF/results.xhtml" />
</ui:fragment>