@Override
    public void doFilter ( final ServletRequest request, final ServletResponse response, final FilterChain chain ) throws IOException, ServletException
    {
            doFilter( (HttpServletRequest) request, (HttpServletResponse) response, chain );
    }

    private void doFilter ( final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain ) throws IOException, ServletException
    {
        if ( isAuthorized( request ) )
        {
            chain.doFilter( request, response );
        }
        else
        {
            response.sendRedirect("/login.html");
        }
    }


    boolean isAuthorized ( final HttpServletRequest request ) throws 
    {
        if ( request.getParameter("password").equals("swordfish") )
            request.getSession().setAttribute("authorized","true");

        return request.getSession().getAttribute("authorized") != null;
    }