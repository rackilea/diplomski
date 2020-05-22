<table>
  <% pageContext.setAttribute("questions", new Questions(){}.QUESTION_ARRAY); %>
  <c:forEach var="question" items="${questions}" varStatus="ctr">
    <tr>
      <td>
        ${questions[ctr.index]} 
      </td>
    </tr>
  </c:forEach>
</table>