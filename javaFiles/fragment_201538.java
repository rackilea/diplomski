@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomerFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // nothing here...
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpSession session = req.getSession(true);

    SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (sci != null) {
      SecureUser user = (SecureUser) sci.getAuthentication().getPrincipal();
      String url = req.getRequestURI();
      if (!user.path.contains("url")) ((HttpServletResponse) response).sendRedirect("http://redirect-URL-Here/");
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}