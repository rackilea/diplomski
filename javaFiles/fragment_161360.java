<c:if test="${repairPartAddNew.clientReportIssuePart != null}">
                <c:set var="loopValue" value="1" scope="page" />
                <c:forEach var="issueClient" items="${repairPartAddNew.issueClientList}" varStatus="loop">
                        <tr>
                            <td>
                                <form:select disabled="disabled" multiple="false" id="clientReportIssuePart${loopValue}" class="form-control input-sm" name="clientReportIssuePart" path="clientReportIssuePart"
                                             onchange="getPartSubtypes(this.value,$(this).parent().next().find('select').attr('id'));">
                                    <form:option value="${issueClient.part}">${issueClient.part}</form:option>
                                    <form:options items="${descriptionParts}" itemValue="value" itemLabel="name"/>
                                </form:select>
                            </td>

                            <td>
                                <form:select disabled="disabled" multiple="false" class="form-control input-sm" id="clientPartType${loopValue}" name="clientPartType" path="clientPartType"
                                             onchange="getRepairPartIssue(this.value,$(this).parent().next().find('select').attr('id'),$(this).parent().prev().find('select').val());">
                                    <form:option value="${issueClient.type}">${issueClient.type}</form:option>
                                </form:select>
                            </td>

                            <td>
                                <form:select disabled="disabled" multiple="false" class="form-control input-sm" id="clientRepair${loopValue}" name="clientReportIssuePartId" path="clientReportIssuePartId">
                                    <form:option value="${issueClient.id_issue}">${issueClient.issue}</form:option>
                                </form:select>
                            </td>
                            <td class="text-center width-100">
                                <button type="button" id="deleteClientRowBtn" class="btn btn-outline btn-sm btn-dark"
                                        onclick="deleteRow(this, $(this).closest('table').attr('id'))">Delete Row
                                </button>
                            <td class="text-center width-100">
                                <button type="button" class="btn btn-outline btn-sm btn-dark"
                                        onclick="addTableRow('tableClientTemplate', $(this).closest('table').attr('id'))">Add Row
                                </button>
                            </td>
                        </tr>
                    <c:set var="loopValue" value="${loopValue + 1}" scope="page"/>
                </c:forEach>
            </c:if>

        </tbody>