public class ErrorHandlerFilter implements Filter {

  ErrorHandler errorHandler;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    try {
      filterChain.doFilter(request, response);
    } catch (Exception ex) {
      // call ErrorHandler and dispatch to error jsp
      String errorMessage = errorHandler.handle(request, response, ex);
      request.setAttribute("errorMessage", errorMessage);
      request.getRequestDispatcher("/WEB-INF/jsp/error/dispatch-error.jsp").forward(request, response);
    }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    errorHandler = (ErrorHandler) WebApplicationContextUtils
      .getRequiredWebApplicationContext(filterConfig.getServletContext())
      .getBean("defaultErrorHandler");
  }

  // ...
}