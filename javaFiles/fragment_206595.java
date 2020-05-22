public class GodFilter implements Filter {

    private Map<Pattern, Filter> filters = new LinkedHashMap<Pattern, Filter>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        Filter1 filter1 = new Filter1();
        filter1.init(config);
        filters.put(new Pattern("/foo/*"), filter1);

        Filter2 filter2 = new Filter2();
        filter2.init(config);
        filters.put(new Pattern("*.bar"), filter2);

        // ...
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        String path = hsr.getRequestURI().substring(hsr.getContextPath().length());
        GodFilterChain godChain = new GodFilterChain(chain);

        for (Entry<Pattern, Filter> entry : filters.entrySet()) {
            if (entry.getKey().matches(path)) {
                godChain.addFilter(entry.getValue());
            }
        }

        godChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        for (Filter filter : filters.values()) {
            filter.destroy();
        }
    }

}