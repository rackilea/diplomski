@Component
public final class MyCustomFilter2 implements Filter {

    public MyCustomFilter2() {
        super();
    }

    @Override
    public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        if (/*is filter2 urls*/) {
        // logic for processing filter2-urls
        }
    }
 }