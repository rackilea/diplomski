<s:iterator value="ticketList" var="tl" status="stat">
                        <tr>
                        <!-- The problem form which should call 2 actions -->
                        <s:form id="ticketForm%{#stat.index}" action="updateTicket" theme="simple">
                        <!-- This hidden field is required in both actions -->
                        <s:hidden name="ticketId" value="%{#tl.id}" />
                        <td valign="top" width="5%"><s:property value="id" /></td>
                        <td valign="top"><s:property value="requesterName" /></td>
                        <td valign="top"><s:property value="guestName" /></td>
                        <input type="button" value="Details" onClick="Javascript:details(<s:property value='%{#stat.index}' />)" />
                        <s:submit value="Update" />
                          </td>
                          </s:form>
                        </tr>

                        <tr>
                          <td colspan="10"><script language="JavaScript">Rule();</script></td>
                        </tr>
                        </s:iterator>