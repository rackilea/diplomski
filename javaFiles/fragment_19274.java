public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
{
    HttpServletRequest httpreq = (HttpServletRequest) request;
    String parentPage = httpreq.getServletPath();
    String includePage = (String) httpreq.getAttribute("javax.servlet.include.servlet_path");
    // Log it here?

    chain.doFilter(request, response);
}