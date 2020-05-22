<c:forEach items="${page.content}" var="topic">
            <div class="form-topic-title">
                <h1><a href="<spring:url value="/logged?page=0&sort=title"/>">Title</a></h1>
                <p><a href="<spring:url value="/logged?page=0&sort=date"/>">Date</a></p>
            </div>
            <div class="form-row">
                <label>
                    <p >${topic.content}</p>
                    <div class="date">
                        <p><a href="<spring:url value="/logged/${topic.id}"/>">${topic.title}</a></p>
                        <p>${topic.date}</p>
                        <p>${topic.author}</p>
                    </div>
                </label>
            </div>
            <div class="form-row">
                <button type="submit" >comment</button>
            </div>
    </c:forEach>
    <a href="<spring:url value="/logged?page=${page.number - 1}&sort=${sort}"/>">Previous</a>
    <a href="<spring:url value="/logged?page=${page.number + 1}&sort=${sort}"/>">Next</a>