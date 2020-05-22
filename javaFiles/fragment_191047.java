<form th:action="@{/handle-file-upload}" th:object="${fileObj}" method="post"
    enctype="multipart/form-data">
    <span>add key</span>
    <input class="btn btn-primary btn-sm" th:field="*{file1}" type="file">
    <span>add key</span>
    <input class="btn btn-primary btn-sm" th:field="*{file2}" type="file">
    <button type="submit">Save</button>
</form>