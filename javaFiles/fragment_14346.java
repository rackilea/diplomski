<tr th:each="listItem : ${list}">
    <td th:text="${listItem.getTitle()}"></td>
    <td th:text="${listItem. getDescription()}"></td>
    <td>
         <div th:if="${listItem.getSubItem(list2)} != null">
           //Show stuff
        </div>
     </td>
</tr>