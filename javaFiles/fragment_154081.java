public void doFilter(ServletRequest request,
      ServletResponse response, FilterChain chain) 
      throws IOException, ServletException {
      DataAccess.set(new DataAccess("SomeValue"));
      try {
        chain.doFilter(request, response);
      } finally {
        DataAcess.remove();
      }
   }