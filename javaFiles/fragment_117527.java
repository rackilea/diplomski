public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse resp = (HttpServletResponse)response;

    String protocol = req.getHeader("X-Forwarded-Proto");

    if (protocol.equals("http")) {
        String url = "https://" + req.getServerName() + req.getContextPath() + req.getServletPath();
        if (req.getPathInfo() != null) {
            url += req.getPathInfo();
        }

        System.out.println("Forwarding request to: " + url);
        resp.sendRedirect(url);
    } else {
        System.out.println("Not forwarding protocol: " + protocol);
        chain.doFilter(request, response);
    }
}