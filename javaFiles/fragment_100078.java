<c:forEach var="EmployeeBean" items="${questionList}" varStatus="status">
   ${EmployeeBean.question_name }

     <c:forEach var="EmployeeBean" items="${optionList.get(status.index)}"><!-- get the related data list -->
       <div class="col-xs-4 starategy-data">
       <div class="strategy-head">${EmployeeBean.answer_type }</div>
       <p>${EmployeeBean.answer }</p>
       </div>
     </c:forEach>
  </c:forEach>