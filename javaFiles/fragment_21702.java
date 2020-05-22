@WebFilter(urlPatterns = "/*")
public class RequestDefaultFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (isForbidden(request, response))
                return;
        else
            chain.doFilter(request, response);
    }
}