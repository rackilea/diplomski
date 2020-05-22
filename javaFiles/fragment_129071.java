<tr th:block th:each="participant, iterStat : ${participants}">
        <td class="table-col-id" th:text="${participant.id}">ex</td>
        <td class="table-player-name" th:text="${participant.name}">example</td>
        <td class="table-col-operation">
            <form th:action="@{/tournament/removePlayer?id={id}(id=${participant.id})}"
                  method="post">
                <button class="player-remove-button table-action-button generic-button"
                        type="submit">Remove
                </button>
            </form>
        </td>
    </tr>