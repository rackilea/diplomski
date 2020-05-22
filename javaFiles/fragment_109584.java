<c:forEach var="surveyItem" items="${surveys}">
    ${surveyItem.title}
    <c:forEach var="question" items="${surveyItem.questions}">
        ${question.title} 
    </c:forEach>
</c:forEach>