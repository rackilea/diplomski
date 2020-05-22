public class TimeoutFilter implements Filter { 

    private static final String TIMEOUT_PAGE = "timeout.html"; 
    private static final String LOGIN_PAGE = "login.faces";  

    public void init(FilterConfig filterConfig) throws ServletException { 
    } 

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException { 
    if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) { 
        HttpServletRequest requestHttp = (HttpServletRequest) request; 
        HttpServletResponse responseHttp = (HttpServletResponse) response; 
        if (checkResource(requestHttp)) {
            String requestPath = requestHttp.getRequestURI();
            if (checkSession(requestHttp)) { 
                String timeoutUrl = hRequest.getContextPath() + "/" + TIMEOUT_PAGE; 
                responseHttp.sendRedirect(timeoutUrl); 
                return; 
            } 
        } 
        filterChain.doFilter(request, response);
    } 

    private boolean checkResource(HttpServletRequest request) { 
        String requestPath = request.getRequestURI(); 
        return !(requestPath.contains(TIMEOUT_PAGE) || requestPath.contains(LOGIN_PAGE) || requestPath.equals(hRequest.getContextPath() + "/")); 
    } 

    private boolean checkSession(HttpServletRequest request) { 
        return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid(); 
    }

    public void destroy() { 
    } 

}