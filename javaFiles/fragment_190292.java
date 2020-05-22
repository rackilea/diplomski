<ul class="first">
 <div th:each="image : ${car.getImageUrl()}" th:if="${!#strings.isEmpty(image)}">
     <li class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
        <a th:href="${image}" class="pop" data-id="${image}">
            <img class="img-responsive thumbnailsmaller" th:src="${image}"/>
        </a>
     </li>
 </div>         
</ul>