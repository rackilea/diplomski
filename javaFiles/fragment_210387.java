public class IE8Filter implements Filter {

    private Logger logger = LoggerHelper.getLogger();

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

         HttpServletRequest request = (HttpServletRequest) req;
         HttpServletResponse response = (HttpServletResponse) res;

         String userAgent = request.getHeader("User-Agent");
         logger.debugf("User Agent  = '%s'", userAgent);

         IE8FilterResponseWrapper wrapper = new IE8FilterResponseWrapper(response);

         if (userAgent.contains("MSIE 8") || userAgent.contains("MSIE 7")) {

             wrapper.forceContentType("text/html");
             chain.doFilter(req, wrapper);

         }
         else {
             chain.doFilter(req, res);
         }


    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

}