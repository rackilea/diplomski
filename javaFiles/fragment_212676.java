while(rs.next()){
    String ques = rs.getString(2);
    String opt1 = rs.getString(3);
    String opt2 = rs.getString(4);
    String opt3 = rs.getString(5);
    String opt4 = rs.getString(6);
    String ans = rs.getString(7);
%>
<%=i%>. <%=ques%><br/>
<input type="radio" name="ans<%=i%>" value="<%=ans%>"/><%=opt1%><br/>
<input type="radio" name="ans<%=i%>" value="<%=ans%>"/><%=opt2%><br/>
<input type="radio" name="ans<%=i%>" value="<%=ans%>"/><%=opt3%><br/>
<input type="radio" name="ans<%=i%>" value="<%=ans%>"/><%=opt4%><br/>
<br/><br/>
<%
    i++;
}