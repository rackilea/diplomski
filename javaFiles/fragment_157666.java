<form th:action="@{'/project_collaborators/' + ${project.id}}" method="post" th:object="${rolesCollaborators}">
    <label th:text="'Edit Collaborators: ' + ${project.name}">Edit Collaborators: Website Project</label>
    <ul class="checkbox-list">

        <li th:each="a, stat : ${assignments}">
            <span th:text="${a.role.name}" class="primary">Developer</span>

            <div class="custom-select">
                <input type="hidden" th:id="rolesCollaborators[__${stat.index}__].roleId" th:name="rolesCollaborators[__${stat.index}__].roleId" th:value="${a.role.id}" />
                <span class="dropdown-arrow"></span>
                <select th:field="*{rolesCollaborators[__${stat.index}__].collaboratorId}">
                    <option th:each="collaborator : ${allCollaborators}" th:value="${collaborator.id}" th:text="${collaborator.name}">Michael Pemulis</option>
                </select>
            </div>
        </li>

    </ul>
    <div class="actions">
        <input type="submit" value="Save" class="button"/>
        <a href="#" class="button button-secondary">Cancel</a>
    </div>
</form>