public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    boolean chainCompleted = implementEnforcement(request, response);
    if (!chainCompleted) {
        filterChain.doFilter(request, response);
    }
}

private boolean implementEnforcement(HttpServletRequest request, HttpServletResponse response) throws IOException {
    final String key = "enforcement.ip";
    HttpSession session = request.getSession(false);
    if (session != null) {
        // we have a session
        String ip = request.getRemoteAddr();
        String ipInSession = session.getAttribute(key);
        if (ipInSession == null) {
            session.setAttribute(key, ip);
        } else {
            if (!ipInSession.equals(ip)) {
                // JSESSIONID is the same, but IP has changed
                // invalidate the session because there is a probability that it is
                // a session hijack
                session.invalidate();
                // a redirection to some page (probably to context root) may be added here
                return true;
            }
        }
    }
    return false;
}