@ApplicationScoped
@WebFilter(filterName = "MyAwesomeFilter", urlPatterns = {"/*"})
public class MyAwesomeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String s = request.getRequestURI() + "/addedSomething"
        request.getRequestDispatcher(s).forward(request, servletResponse);
    }

    @Override
    public void destroy() {
    }
}