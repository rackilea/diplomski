<div th:each="bookObj : ${BookList}"> 
    <form action="#" th:action="@{/books/delete}" method="post">
        <input type="hidden" th:name="genre" th:value="${bookObj.genre}"/>
        <input type="hidden" th:name="author" th:value="${bookObj.author}"/>
        <input type="hidden" th:name="title" th:value="${bookObj.title}"/>
        <input type="submit" th:value="${bookObj.title}"/>
    </form>
</div>