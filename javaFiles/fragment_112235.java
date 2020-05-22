@Override
public void onLogoutSuccess(HttpServletRequest request,
        HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {
    if(authentication != null) {
        System.out.println(authentication.getName());
    }
    //perform other required operation

    String URL = request.getContextPath();
    response.setStatus(HttpStatus.OK.value());
    response.sendRedirect(request.getHeader("referer"));
}