public class SessionFilter implements Filter {

    private ArrayList<String> urlList;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        boolean allowedRequest = false;

        if(urlList.contains(url)) {
            allowedRequest = true;
        }

        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            if (null == session) {
                System.out.println("preparing for redirect");
                response.sendRedirect("index.jsp");
                return;
            }
        }

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("entered init");
        String urls = config.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

        urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());

        }
    }