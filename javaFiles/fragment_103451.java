static class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl{




    @Override
    public void handle(HttpServletRequest request,
            HttpServletResponse response,

  AccessDeniedException accessDeniedException)
    throws IOException, ServletException {
if (accessDeniedException instanceof MissingCsrfTokenException
        || accessDeniedException instanceof InvalidCsrfTokenException) {

    if(request.getRequestURI().contains("login")){
        response.sendRedirect(request.getContextPath()+"/login");                                        
    }
}

super.handle(request, response, accessDeniedException);



 }
}