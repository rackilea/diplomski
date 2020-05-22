@Override
protected String requestUrlToTemplatePath(HttpServletRequest request) 
throws ServletException {

    String path = super.requestUrlToTemplatePath(request);

    //Check if NOT_FOUND_PAGE is requested
    if(request.getAttribute(NOT_FOUND_PAGE) != null) {
        path =  (String) request.getAttribute(NOT_FOUND_PAGE);      
    }

 return path;
 }