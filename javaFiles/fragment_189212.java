@Override
public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
    throws IOException,ServletException{

    HttpServletRequest request=(HttpServletRequest)req;
    String path=request.getServletPath();

    if(path.equals("/") || path.equals("/index.html"){
        // do your thing
    }

    chain.doFilter(req,res);
}