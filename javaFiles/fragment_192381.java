<h3>
    Showing available Service Providers :
    <c:out value="${serviceProvider}" />
    </h3>
    <ul>
    <c:forEach items="${serviceProviders}" var="sp">
        <li><c:out value="${sp.name}" /> <c:if test="${sp.connected}"> : Connected with Permissions : <c:out
                    value="${sp.permissions}" />
                <form action="<c:url value="<%=Uris.DISCONNECT%>" />" method="POST">
                    <button type="submit">Disconnect</button>
                    <input type="hidden" name="sp" value="${sp.name}" />
                </form>
            </c:if> 
            <c:if test="${!sp.connected}"> : Disconnected  
            <form action="<c:url value="${sp.URL }" />" method="POST">
                    <button type="submit">Connect</button>
                    <input type="hidden" name="scope" value="${sp.permissions}" />
                </form></c:if></li>
    </c:forEach>
</ul>