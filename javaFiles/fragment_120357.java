public class PublicFilter implements Filter {

    private FilterConfig filterConfig;
    public static final String PUBLIC_METHODS = "com.example.access.PUBLIC_METHODS";
    static final String IS_PUBLIC = "com.example.access.IS_PUBLIC";

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final List<String> allowedMethods = Arrays.asList(filterConfig.getInitParameter(PUBLIC_METHODS).split(","));
        final String method = ((HttpServletRequest) request).getMethod();

        if (allowedMethods.contains(method)) request.setAttribute(IS_PUBLIC, true);
        chain.doFilter(request, response);
    }

    public void destroy() {}
}