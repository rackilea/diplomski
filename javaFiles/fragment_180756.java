@WebFilter("/*")
    public class redirectOnSessionCount implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        Integer sessionCount = (Integer) request.getServletContext().getAttribute("SESSION_COUNT");//fetching session count from application scope
            if(sessionCount!=null && sessionCount>2 && ! httpRequest.getRequestURL().toString().contains("Error.jsp")){
             //httpRequest.getRequestURL().toString().contains("Error.jsp") - > if it's already redirecting to error.jsp then no redirection 
                httpResponse.sendRedirect("Error.jsp");//redirection code
            }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}