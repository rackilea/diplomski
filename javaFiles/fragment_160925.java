<table>
  <% pageContext.setAttribute("questions", Questions.QUESTION_ARRAY); %>
  <c:forEach var="question" items="${questions}" >
    <tr>
      <td>
        ${question}
      </td>
    </tr>
  </c:forEach>
</table>