<table>
  <% pageContext.setAttribute("questions", Questions.QUESTION_ARRAY); %>
  <c:forEach var="question" items="${questions}" varStatus="ctr">
    <tr>
      <td>
        <%=Questions.QUESTION_ARRAY[((LoopTagStatus)pageContext.getAttribute("ctr")).getIndex()]%>
      </td>
    </tr>
  </c:forEach>
</table>