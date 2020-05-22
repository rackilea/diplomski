<% int counter = 1; %>
<table class="styledLeft" id="moduleTable">
            <thead>
                <tr>
                    <th width="10%">No</th>
                    <th width="10%">Model No</th>
                    <th width="30%">Model/Make</th>
                    <th width="30%">Price</th>
                    <th width="20%">Available Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Map.Entry<String, String[]> entry : orders.entrySet()) {
                %>
                <tr>
                    <td><%=counter++%></td>
                    <td><%=entry.getKey()%></td>
                    <%for (String arrayElement: entry.getValue()) {%>
                    <td><%=arrayElement%></td>
                    <%
                    }
                    %>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>