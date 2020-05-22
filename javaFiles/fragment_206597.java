public class GodFilterChain implements FilterChain {

    private FilterChain chain;
    private List<Filter> filters = new ArrayList<Filter>();
    private Iterator<Filter> iterator;

    public GodFilterChain(FilterChain chain) {
        this.chain = chain;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (iterator == null) {
            iterator = filters.iterator();
        }

        if (iterator.hasNext()) {
            iterator.next().doFilter(request, response, this);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void addFilter(Filter filter) {
        if (iterator != null) {
            throw new IllegalStateException();
        }

        filters.add(filter);
    }

}