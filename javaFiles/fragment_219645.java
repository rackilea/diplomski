<div th:if="${status.value} eq 'COMPLETE' or ${status.value} eq 'INVALID'">
    <!-- print object is not active -->
</div>
<div th:if="${status.value} eq 'NEW'">
    <!-- print object is new and active -->
</div>