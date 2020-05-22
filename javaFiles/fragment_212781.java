<ul class="list-unstyled">
        <!-- 
        - parent and children are saved in the same table, so i'm not worried about ids overlapping
        -->

        <li th:each="service_el : ${services_list}" >
            <input type="checkbox" name="chk_services" th:value="${service_el.id}" th:checked="${#lists.contains(checked_services, '' + service_el.id)}"/>
            <label th:text="${service_el.title}" th:for="'chk_services' + ${service_el.id}">service</label>

            <ul class="list-unstyled-padding">
                <li th:each="subservice_el : ${service_el.children}">
                    <input type="checkbox" name="chk_services" th:value="${subservice.id}" th:checked="${#lists.contains(checked_services, '' + subservice.id)}"/>
                    <label  th:text="${subservice.title}" th:for="'chk_services' + ${service_el.id}">subservice</label>
                </li>
            </ul>              
        </li>
    </ul>