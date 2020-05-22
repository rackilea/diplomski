<th:block th:each="item : ${items}">
    <!-- Item -->
    <li class="item">
        item content ...
    </li>
    <!-- Children -->
    <li th:each="child : ${item.children}" class="item1 hidden nojs">
        child content ...
    </li>
</th:block>