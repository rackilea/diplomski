<div th:unless="${status.value} eq 'NEW'">
    <!-- print object is not active -->
</div>
<div th:if="${status.value} eq 'NEW'">
    <!-- print object is new and active -->
</div>