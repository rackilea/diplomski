if(request.getParameter("language")==null) {
  String userLocale = request.getHeader("Accept-Language");
  Locale locale = request.getLocale();

  if(req.getRequestUrl().contains("?")) {
   response.sendRedirect(req.getRequestUrl()+"&language="_locale.getLanguage());
  } else {
   response.sendRedirect(req.getRequestUrl()+"?language="_locale.getLanguage());
  }
 }