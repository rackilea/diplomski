@WebFilter(filterName = "impersonateFilter", urlPatterns = "/*", asyncSupported = true)
public class ImpersonateFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ImpersonateRequest impersonateRequest = new ImpersonateRequest(httpRequest);
        chain.doFilter(impersonateRequest, response);
    }

    @Override
    public void destroy()
    {
        // do nothing
    }

    public static class ImpersonateRequest extends HttpServletRequestWrapper
    {
        protected Principal principal;

        public ImpersonateRequest(HttpServletRequest request)
        {
            super(request);

            HttpSession session = request.getSession(false);
            if(session != null)
            {
                principal = (Principal) session.getAttribute(ImpersonateRequest.class.getName());
            }
        }

        @Override
        public Principal getUserPrincipal()
        {
            if(principal == null)
            {
                principal = super.getUserPrincipal();
            }

            return principal;
        }

        public void setUserPrincipal(Principal principal)
        {
            this.principal = principal;
            getSession().setAttribute(ImpersonateRequest.class.getName(), principal);
        }

        @Override
        public String getRemoteUser()
        {
            return principal == null ? super.getRemoteUser() : principal.getName();
        }
    }
}