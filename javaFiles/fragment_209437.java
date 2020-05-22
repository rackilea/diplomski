<div th:each="bookObj, iter : ${session.BookList}">
    <form action="#" th:action="@{/books/delete}" method="post">
        <input type="hidden" th:name="id" th:value="${iter.index}"/>
        <input type="submit" th:value="${bookObj.title}"/>
    </form>
</div>