<ul>
    <ui:repeat value="#{pageBean.pages}" var="page">
        <li class="#{view.viewId == page.viewId ? 'current_page_item' : ''}">
            <h:link value="#{page.name}" outcome="#{page.viewId}" />
        </li>
    </ui:repeat>
</ul>