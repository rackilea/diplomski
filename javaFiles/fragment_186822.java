public class RequestContextFilter implements javax.servlet.Filter {

        private static final String CLASS_NAME = MdcFilter.class.getName();
        private static final Logger logger = Logger.getLogger("");
        private volatile Handler emailer;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            emailer = new SMTPHandler();
            //etc...
            emailer.setFormatter(new ContextFormatter());
            logger.addHandler(emailer);
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            ContextFormatter.CTX.set(request);
            try {
                chain.doFilter(request, response);
            } finally {
                ContextFormatter.CTX.remove();
            }
        }

        @Override
        public void destroy() {
            logger.removeHandler(emailer);
            emailer.close();
        }

        private static class ContextFormatter extends Formatter {

            static final ThreadLocal<ServletRequest> CTX = new ThreadLocal();
            private final Formatter txt = new SimpleFormatter();

            @Override
            public String format(LogRecord record) {
                HttpServletRequest req = (HttpServletRequest) CTX.get();
                return req.getRequestURI() + " " + txt.format(record);
            }
        }
    }