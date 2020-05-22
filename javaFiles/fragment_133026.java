<%
  for (String attributeName : pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE))
  {
    out.println(attributeName + " = " + pageContext.getAttribute(attributeName));
  }
%>