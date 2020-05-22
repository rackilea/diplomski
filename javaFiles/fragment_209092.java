<%
List<String> stuff = new ArrayList<String>();
request.setAttribute("mystuff", stuff);
%>

<c:out value="${mystuff" />