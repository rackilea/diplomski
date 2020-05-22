<form 
        th:action="@{/admin/addPost}" 
        th:object="${post}" 
        method="post">
        <input 
            id="post_name_input"
            placeholder="Post name" 
            th:field="*{name}" />
        <br>

        <textarea
            id="post_description_textarea"
            class="wide-input"
            placeholder="Post content" 
            th:field="*{description}" />
        <br>
        <button type="submit">Create</button>
    </form>