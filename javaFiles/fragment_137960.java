public class PersistenceManagerFilter implements javax.servlet.Filter {

  public init(FilterConfig filterConfig) {
    Datastore.initialize();
  }

  public void doFilter(ServletRequest request, 
      ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    try {
      chain.doFilter(request, response);
    } finally {
      Datastore.finishRequest();
    }    
  }
}