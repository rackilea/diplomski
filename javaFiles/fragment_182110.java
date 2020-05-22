public class CharacterEncodingFilter implements javax.servlet.Filter {

  // ...

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    filterChain.doFilter(request, response);
  }
}