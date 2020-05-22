public class MockSpringSecurityFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) {}

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    SecurityContextHolder.getContext()
      .setAuthentication((Authentication) ((HttpServletRequest) req).getUserPrincipal());
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {
    SecurityContextHolder.clearContext();
  }
}