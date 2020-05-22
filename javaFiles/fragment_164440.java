public class WelcomFilter implements javax.servlet.Filter {

/** {@inheritDoc} */
@Override
public void init(FilterConfig filterConfig) throws ServletException {

}

/** {@inheritDoc} */
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (request instanceof HttpServletRequest) {
        HttpServletRequest r = (HttpServletRequest) request;
        if ("/".equals(r.getPathInfo())) {
            r.getRequestDispatcher("index.html").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    } else {
        chain.doFilter(request, response);
    }
}

/** {@inheritDoc} */
@Override
public void destroy() {

}
}