<select th:name="*{requestedUser}">
  <option th:each="user : ${users}"
     th:value="${user.id}"
     th:text="${user.name}"
     th:selected="${requestedUser.id == user.id}">
  </option>
</select>