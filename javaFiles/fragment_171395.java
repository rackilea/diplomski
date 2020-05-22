@Override
public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    filterChain.doFilter(request, response);
    if(response.getContentType().indexOf("text/html")>-1){
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setHeader("Cache-Control","no-cache,no-store,max-age=0,s-maxage=0,must-revalidate,proxy-revalidate,private,max-stale=0,post-check=0");
        httpResponse.setDateHeader("Expires", 0L);
    }
}