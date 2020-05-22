<form th:object="${user}">
    <div class="form-group">
        <label class="control-label required"></label>
        <select id="maritalStatus" class="form-control required" th:field="*{maritalStatus}">
            <option value=""></option>
            <option th:each="status : ${maritalStatuses}" th:value="${status}" 
                th:text="${status}"></option>
        </select>
    </div>
    <div class="form-group">
        <label class="control-label"></label>
        <select id="gender" class="form-control" th:field="*{gender}">
            <option value=""></option>
            <option th:each="e : ${genders}" th:value="${e.name}" 
                th:text="${e}"></option>
        </select>
    </div>
</form>