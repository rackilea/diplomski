@Override
public void doFilter (
        final ServletRequest request,
        final ServletResponse response,
        final FilterChain chain
    ) throws
        IOException,
        ServletException
{
    if ( isHalfDead )
    {
        // redirect to error page
        return;
    }

    chain.doFilter( request, response );
}