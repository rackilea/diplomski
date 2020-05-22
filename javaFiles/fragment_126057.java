<%
Boolean status = (Boolean) session.getAttribute("REPORT_OK");
if(status==null){
    //dont return anything
}else if(status){
    out.print("Report is ok");
}else {
    out.print("Report generation failed ");
}
%>