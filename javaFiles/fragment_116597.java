<%@page import="org.json.simple.JSONObject"%>

<%
if (request.getParameter("name") != null)
{
   response.setContentType("application/json");

   ... your select query ...

   JSONObject json = new JSONObject();
   ... put your sql data like this ...
   json.put("name", "hello");
   json.put("type", "world");

   response.getWriter().write(json.toString());
}
%>