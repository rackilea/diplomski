<% List mydata= (List)request.getAttribute("data");

Iterator itr = mydata.iterator();
while (itr.hasNext()) {
    Agent currentAgent = itr.next();%> 
        <tr>
            <td  style="border-right: 1px dotted grey;" align="center" width="15%"> <%=currentAgent.status%></td>
            <td  style="border-right: 1px dotted grey;" align="center" width="15%"> <%=currentAgent.customerId%></td>
            ...
            ...
            ...
        <tr>
<%}%>