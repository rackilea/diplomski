<!-- th:block rather than unneeded div -->
<th:block th:switch="${status.value}">
    <div th:case="'COMPLETE'">
        <!-- print object is not active -->
    </div>
    <div th:case="'INVALID'">
        <!-- print object is not active -->
    </div>
    <div th:case="'NEW'">
        <!-- print object is new and active -->
    </div>
</th:block>