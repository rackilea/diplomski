/**
 * Sets character encoding on the request and response.
 *
 * @author gaurav
 */
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            response.setCharacterEncoding("UTF-8");
        } finally {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() { }
}