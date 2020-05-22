<div id="accordion">
    <c:forEach items="${itemsPerOwner}" var="itemsPerOwnerEntry">
        <h3>${itemsPerOwnerEntry.key}</h3>
        <div>
            <c:forEach var="item" items="${itemsPerOwnerEntry.value}">
                ${item.foo}, ${item.bar}  <br/>
            </c:forEach>
        </div>
    </c:forEach>
</div>