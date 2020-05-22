public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
        ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    MyUser user = (MyUser) request.getSession(true).getAttribute("user");

    if (user == null) {

        String uuid = CookieUtil.getCookieValue(request, CookieUtil.COOKIE_NAME);

        if (uuid != null) {
            user = ub.findUserByUUID(uuid);

            if (user != null) {
                request.getSession().setAttribute("user", user);
                CookieUtil.addCookie(response, CookieUtil.COOKIE_NAME, uuid, CookieUtil.COOKIE_AGE);
            } else {
                CookieUtil.removeCookie(response, CookieUtil.COOKIE_NAME);
            }
        }
    }

    // pass the request along the filter chain
    chain.doFilter(req, res);
}