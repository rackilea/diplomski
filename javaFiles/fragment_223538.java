@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

  final HttpServletRequest request = (HttpServletRequest) servletRequest;

  // handle code(s)
  final int code = (Integer) request.getAttribute("javax.servlet.error.status_code");
  if (code == 404) {
    final String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
    request.setAttribute("errorMessage", "The requested page '" + uri + "' could not be found.");
  }

  // notify chain
  filterChain.doFilter(servletRequest, servletResponse);
}