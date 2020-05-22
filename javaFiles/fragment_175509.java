@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (isYourConfigurationFileSettingSet()) {
        chain.doFilter(request, response);
    } else {
        ((HttpServletResponse) response).sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}