<ul id="nav">
    <c:forEach items="${pages}" var="page">
        <c:set var="active" value="${fn:endsWith(pageContext.request.requestURI, page.url)}" />
        <li class="${active ? 'active' : 'none'}"><a href="${page.url}">${page.name}</a></li>
    </c:forEach>
</ul>