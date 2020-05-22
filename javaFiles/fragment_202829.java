@WebFilter(filterName = "monitoringFilter", urlPatterns = { "/*" })
public class MonitoringFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    {
        // Right here do your stuff pretty much like in a servlet
        request // ... get information you need

        // Process request as normal
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException
    {

    }

    @Override
    public void destroy()
    {

    }
}