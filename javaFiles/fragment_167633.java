<ul>
    <ui:repeat value="#{bean.categories}" var="category">
        <li>#{category.cateName}
            <h:panelGroup rendered="#{not empty category.subCatList}">
                <ul>
                    <ui:repeat value="#{category.subCatList}" var="subCat">
                        <li>#{subCat.subcatName}</li>
                    </ui:repeat>
                </ul>
            </h:panelGroup>
        </li>
    </ui:repeat>
</ul>