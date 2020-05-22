<%
List<Map<String, String>> results = (List<Map<String, String>>)request.getAttribute("verify");
for (Map<String, String> verify: results) {
{ 
    out.print(verify.get("aadhaar"));
    out.print(verify.get("scheme"));
    out.print(verify.get("beneficiaryID")+"$"+verify.get("name"));
}
%>