<c:forEach items="${(List<News>) request.getAttribute("news")}" var="news">
    <div class="card text-white bg-info mb-3" style="max-width: 18rem;">
        <div class="card-header">gggggggggggggggggg</div>
        <div class="card-body">
            <h5 class="card-title">${news.title}</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        </div>
    </div>
</c:forEach>