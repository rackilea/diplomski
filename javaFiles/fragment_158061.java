public class LimitFilter implements Filter {
    private int limit = 5;
    private int count;
    private Object lock = new Object();

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            boolean ok;
            synchronized (lock) {
                ok = count++ < limit;
            }
            if (ok) {
                // let the request through and process as usual
                chain.doFilter(request, response);
            } else {
                // handle limit case, e.g. return status code 429 (Too Many Requests)
                // see http://tools.ietf.org/html/rfc6585#page-3
            }
        } finally {
            synchronized (lock) {
                count--;
            }           
        }
    }
}