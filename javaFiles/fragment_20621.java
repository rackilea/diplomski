<%
  String queryString =  request.getQueryString();
  if(queryString != null) {
    response.sendRedirect("http://xxx.com/yyy/x/search?" + queryString); 
  }
  else {
    response.sendRedirect("http://xxx.com/yyy/x/search"); 
  }
%>