<ul class="list-unstyled">
    <li  th:each="agency_el : ${agencies_list}">
        <input name="chk_agencies" type="checkbox" th:id="'chk_agencies' + ${agency_el.id}" th:value="${agency_el.id}" th:checked="${#lists.contains(checked_agencies, '' + agency_el.id)}" />
        <label th:text="${agency_el.name}" th:for="'chk_agencies' + ${agency_el.id}">agency</label>            
    </li>
</ul>