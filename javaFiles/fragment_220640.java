<dl>
    <ui:repeat value="#{initParam.entrySet().toArray()}" var="p">
        <dt>#{p.key}</dt>
        <dd>#{p.value}</dd>
    </ui:repeat>
</dl>