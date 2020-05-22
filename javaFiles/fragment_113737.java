<% String c,a;
        String[] CA =(String[])session.getAttribute("CA");
        String[] AS =(String[])session.getAttribute("AS");
        List<quest> l=(List<quest>)session.getAttribute("myquestion");
        quest[] question = new quest[l.size()];
        l.toArray(question);
    %>
    <table border=1>
        <tr>
            <th  colspan="2" width="500">Questions</th>
            <th>CorrectAnswer</th>
            <th>Answer sheet</th>
        </tr>
        <% 
            for(pos=0;pos<question.length;pos++){
            String ques=question[pos].ques;
            String opa=question[pos].opa;
            String opb=question[pos].opb;
            String opc=question[pos].opc;
            String opd=question[pos].opd;
            c=CA[pos];
            a=AS[pos];
        %>
            <tr><!-- moved tr inside for loop-->
                <td>Question <%=pos+1%></td>
                <td width="500"><%= ques %></td>
                <td><%=c  %></td>
                <td><%= a%></td><!-- added missing /td-->
            </tr>
        <%} %>
    </table><!-- moved /table outside of for loop-->
</body>