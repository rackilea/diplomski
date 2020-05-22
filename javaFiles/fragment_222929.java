public class MyFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {

    /* wrap the request in order to read the inputstream multiple times */
    MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);

    doMyThing(multiReadRequest.getInputStream());
    chain.doFilter(multiReadRequest, response);
  }
}