<c:forEach items="${questionsForSubject}" var="question">
    <tr>
        <td>
            <input type="checkbox" name="chosen_question" value="${question.questionId}" />
            ${question.question}
            <br />
        </td>
    </tr>
</c:forEach>