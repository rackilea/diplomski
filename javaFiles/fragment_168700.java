<select th:field="*{categoryId}">
   <option th:each="category : ${categories}"
      th:value="${category.id}"
      th:utext="${category.name}"/>
      <!-- <option th:each="category : *{categories}"
         th:value="*{category.id}"
         th:utext="*{category.name}"/> -->
</select>