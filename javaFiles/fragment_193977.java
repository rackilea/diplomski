@Component
public final class MyCustomFilter implements Filter {

    public MyCustomFilter() {
        super();
    }

    @Override
    public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
    // logic for processing filter2-urls and filter1-urls
    }
 }