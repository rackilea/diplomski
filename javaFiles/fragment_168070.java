<c:forEach items="${List2}" var="as" varStatus="vs">

                    <tr class="rule">
                        <td><input type="hidden" name="ruleList[${vs.index}].id" value="${as.rule.id}" /> ${as.rule.id}</td>
                        <td><input type="hidden" name="ruleList[${vs.index}].ruleName" value="${as.rule.ruleName}" /> ${as.rule.ruleName}</td>
                        <td>&nbsp;<input id="one" class="datepicker" type="text" name="ruleList[${vs.index}].startDate" size="11" height="0.10"></td>
                        <td>&nbsp;<input id="two" class="datepicker" type="text" name="ruleList[${vs.index}].endDate" size="11" height="0.10"></td>
                        <td>
                            <table border="1">
                                <c:forEach items="${as.ruleAssignmentParameter}" var="asss" varStatus="assignments">
                                    <tr>
                                        <td><input type="hidden" name="ruleList[${vs.index}].ruleAssignmentParameter[${assignments.index}].parameterName" value="${asss.parameterName}" > ${asss.parameterName}</td>
                                        <td><input type="hidden" name="ruleList[${vs.index}].ruleAssignmentParameter[${assignments.index}].overwriteValue" value="${asss.overwriteValue}" /> ${asss.overwriteValue}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>