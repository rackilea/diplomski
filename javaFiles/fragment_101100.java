public class AddSessionIdToLogFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {

            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                String sessionID = httpRequest.getSession().getId();

                MDC.put("SessionID", sessionID);
            }   

            ...