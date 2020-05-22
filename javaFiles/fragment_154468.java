public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
  Connection conn = obtainConnection(); // obtain connection and store it ThreadLocal
  conn.setAutoCommit(false);
  try {
    chain.doFilter(request, response);
  } finally {
    conn.commit();
  }
}