@Component
public class CustomFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        request.getSession().setAttribute("ORIGINAL_REQUEST_URI", request.getRequestURI());
        chain.doFilter(request, response);

        // alternatively, ignore the last 2 lines
        // and just do your redirects from here 
        // and don't continue the filter chain
    }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig arg0) throws ServletException {}

}