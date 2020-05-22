@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {


    String uri = ((HttpServletRequest)request).getRequestURI();

    @SuppressWarnings("rawtypes")
    Map session = ActionContext.getContext().getSession();

    if ( uri.indexOf("/css") > 0){
        chain.doFilter(request, response);
    }
    else if( uri.indexOf("/images") > 0){
        chain.doFilter(request, response);
    }
    else if( uri.indexOf("/js") > 0){
        chain.doFilter(request, response);
    }
    else if (session.containsKey("login")) {
        chain.doFilter(request, response);
    }
    else {
        ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login?authentication=failed");
    }
}