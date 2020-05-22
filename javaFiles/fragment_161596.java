<%
    long val = 2;   //can be anything.
    if(val > 1) {
%>
<input id="vendorName" name="vendorName" type="text" class="txtsmall2" value="<%=str%>"/>
<%
    else {
%>
<input id="vendorName" name="vendorName" type="text" class="txtsmall2" />
<%
    }
%>