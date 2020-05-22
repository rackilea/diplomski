/**
 * Closes SQL connections at the end of an HTTP request.
 * 
 * @author Gili Tzabari
 */
public class ConnectionFilter implements Filter
{
    private final Injector injector;

    @Inject
    public ConnectionFilter(Injector injector)
    {
        this.injector = injector;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                                             FilterChain chain)
        throws IOException, ServletException
    {
        Session session = injector.getInstance(Session.class);

        try
        {
            chain.doFilter(servletRequest, servletResponse);
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public void destroy()
    {
    }
}