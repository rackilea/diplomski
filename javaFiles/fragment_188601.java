<select  name="jTitle" id="jTitle" style="background-color: #D8D8D8" onchange="setText(this)">
<%
String str=""; 
Statement stt = conn.createStatement();
ResultSet rstt = stt.executeQuery("SELECT JT_JOB_TITLE, JT_JOB_DESCRIPTION FROM uap.dbo.UAP_JOB_TITLE ORDER BY JT_JOB_TITLE");
while (rstt.next()) { 
str+=rstt.getString(1)+"@"+rstt.getString(2)+"#"; 
%>
<option value="<%=rstt.getString("JT_JOB_TITLE")%>"><%=rstt.getString("JT_JOB_TITLE")%>
</option>
<%
}
stt.close();
rstt.close();
%>
</select>

<input type="hidden" name="txtHidStr" id="txtHidStr" value="<%=str %>" /> 

<textarea class="styled" rows="5" cols="12" name="jDesc" id="jDesc" ></textarea>