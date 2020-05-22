<dl>
    <c:forEach items="#{initParam}" var="p">
        <dt>#{p.key}</dt>
        <dd>#{p.value}</dd>
    </c:forEach>
</dl>