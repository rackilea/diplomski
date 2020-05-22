<%
  String propertyName = request.getParameter("property");
  Object propertyValue;
  String typeString;
  if(null == propertyName)
    propertyValue = null;
  else
    propertyValue = System.getProperty(propertyName);

  if(null == propertyValue)
    typeString = "null";
  else
    typeString = propertyValue.getClass().getName();
%>
The system property <code><%= propertyName %></code> has the value:
<code><%= propertyValue %></code> (<%= typeString %>).