public abstract class SSLOnlyFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  {
    // ... cast to HTTP counterparts
    if (request.isSecure()) {
      chain.doFilter(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_OK);
      // Set the message in the body
    }
  } 
}