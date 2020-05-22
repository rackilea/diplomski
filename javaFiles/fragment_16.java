public abstract class SSLOnlyFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  {
    // cast to HTTP request and response
    if (request.isSecure()) {
      chain.doFilter(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
      // Edit this line with actual parameters. Note HTTPS
      response.setHeader("Location", "https://host:port/url");
    }
  } 
}