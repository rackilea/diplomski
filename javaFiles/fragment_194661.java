<div th:each= "user: ${joinData}">
    <span th:text="${user.username}">
    </span>
    <div th:each="priv: ${user.privJoin}">
      <span th:text="${priv.pname}">
      </span>
    </div>
</div>