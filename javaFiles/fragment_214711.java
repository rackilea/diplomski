public class InactivityFilter implements Filter {

    private static final long MAX_INACTIVE_SESSION_TIME = 5 * 1000;

    public void init(FilterConfig config) throws ServletException {
        System.out.println("InactivityFilter.init()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();
        System.out.printf("InactivityFilter.doFilter(): requestURI = %s; ", requestURI);

        Long firstAccessTime = (Long) request.getSession().getAttribute("lastAccessTime");

        if (firstAccessTime == null) {
            request.getSession().setAttribute("lastAccessTime", new Date().getTime());
            chain.doFilter(req, resp);
        }

        if (firstAccessTime != null) {
            if (System.currentTimeMillis() - firstAccessTime > MAX_INACTIVE_SESSION_TIME) {
                request.getSession().invalidate();
                response.sendRedirect("the url for login page");
                return;
            } else {
                request.getSession().setAttribute("lastAccessTime", new Date().getTime());
                chain.doFilter(req, resp);
            }

        }

    }

    public void destroy() {
        System.out.println("InactivityFilter.destroy()");
    }

}