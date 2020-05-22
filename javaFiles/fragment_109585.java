<c:forEach var="entry" items="${surveyMap}">
    Map Key:  ${entry.key}
    Map Value:  ${entry.value}
    Nested Property:  ${entry.value.title}
    Nested Collection:
    <c:forEach var="question" items="${entry.value.questions}">
        ${question.title}
    </c:forEach>
</c:forEach>