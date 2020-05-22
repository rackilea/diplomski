public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { 

  request.getRequestDispatcher("index_test.jsp").forward(request, response);
  ((HttpServletResponse)response).sendRedirect("new.jsp");
  chain.doFilter(request, response);
 }