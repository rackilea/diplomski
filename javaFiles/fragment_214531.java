<div class="Holder" th:if="${predStatus.namePrem}">
            <ul id="holder" class="price-table__info">
                <li>
                    <p class="exam1" th:text="#{exam2}"></p>
                </li>
            </ul>

        <ul id="holder" class="price-table__info">
            <li>
                <p th:unless="${predStatus.kom}" class="top" th:text="#{usp}"></p>
                <p th:if="${predStatus.kom}" class="top" th:text="#{usp1}"></p>
            </li>
        </ul>
</div>