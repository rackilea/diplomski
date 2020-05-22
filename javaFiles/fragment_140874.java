<%
  mb = mailingbean.getResultProdInfo();
  request.setAttribute("mb", mb);
%>
<data>
  <item>
    <c:out value="<ColourCd>${mb.apid}</ColourCd>" />
  </item>
</data>