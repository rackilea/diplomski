/**
 * Http logging filter, which wraps around request and response in
 * each http call and logs
 * whole request and response bodies. It is enabled by 
 * putting this instance into filter chain
 * by overriding getServletFilters() in  
 * AbstractAnnotationConfigDispatcherServletInitializer.
 */
public class LoggingFilter extends AbstractRequestLoggingFilter {

private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
    long id = System.currentTimeMillis();
    RequestLoggingWrapper requestLoggingWrapper = new RequestLoggingWrapper(id, request);
    ResponseLoggingWrapper responseLoggingWrapper = new ResponseLoggingWrapper(id, response);
    log.debug(id + ": http request " + request.getRequestURI());
    super.doFilterInternal(requestLoggingWrapper, responseLoggingWrapper, filterChain);
    log.debug(id + ": http response " + response.getStatus() + " finished in " + (System.currentTimeMillis() - id) + "ms");
}

@Override
protected void beforeRequest(HttpServletRequest request, String message) {

}

@Override
protected void afterRequest(HttpServletRequest request, String message) {

}
}