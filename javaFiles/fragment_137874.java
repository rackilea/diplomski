@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MDCClearFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, 
                         ServletResponse response, 
                         FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(request, response);
        MDC.clear();
    }
}