<% if(rsmatches!=null && rsmatches.next()){%>
<table>
    <tr>
        <td class="captions">Match</td>
        <td>

        <select>
        <%

            do{ //Change to do while since result set is already pointing to the first row coz of the statement in if loop
        %>
                <option value="<%out.print(rsmatches.getString("matchid"));%>"><%out.print(rsmatches.getString("matchid"));%> - <%out.print(rsmatches.getString("team1name"));%> vs <%out.print(rsmatches.getString("team2name"));%></option>
            <%} while(rsmatches.next()) ;%>
        </select>
        </td>
    </tr>
</table>
<%} else{%>
<h1>No Result</h1>
<%}%>