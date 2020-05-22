<rich:dataTable
    value="#{backingBean.companyList}"
    rows="100"
    var="company">
    <f:facet name="header">
        <rich:columnGroup>
            <rich:column>Company Name</rich:column>
            <rich:column>Company Email</rich:column>
            <rich:column>Product Name</rich:column>
            <rich:column>Product Email</rich:column>
        </rich:columnGroup>
    </f:facet>
    <rich:subTable value="#{company.products}" var="product" rowKeyVar="rowKey">
        <rich:column rowspan="#{company.products.size()}" rendered="#{rowKey eq 0}">
            #{company.name}
        </rich:column>
        <rich:column rowspan="#{company.products.size()}" rendered="#{rowKey eq 0}">
            #{company.email}
        </rich:column>
        <rich:column>
            #{product.name}
        </rich:column>
        <rich:column>
            #{product.email}
        </rich:column>
    </rich:subTable>
</rich:dataTable>