public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
{
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;        
    if(httpRequest.isSecure() || isHostAllowed(servletRequest.getRemoteHost()) ){
        filterChain.doFilter(servletRequest, servletResponse);
    } else{
        String url  = "https://"+servletRequest.getServerName() + "/" + httpRequest.getRequestURI();
        httpResponse.sendRedirect(url);
    }
}