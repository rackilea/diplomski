@Component
public class ResponseHeaderFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) resp;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
    String dateString = simpleDateFormat.format(UnixTime.now() * 1000);

    response.setHeader("Date", dateString);
    response.setHeader("Content-Type", "application/json;charset=UTF-8");

    chain.doFilter(req, resp);

  }

  @Override
  public void destroy() {

  }
}