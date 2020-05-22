public void doFilter(ServletRequest request,
      ServletResponse response, FilterChain chain) 
      throws IOException, ServletException {
// do pre-servlet work here
chain.doFilter(request, response);
// do post servlet work here

}