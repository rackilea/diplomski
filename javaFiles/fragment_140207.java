@Slf4j
public class MethodArgumentTypeMismatchExceptionLoggingExceptionHandler implements HandlerExceptionResolver {
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    if (ex instanceof MethodArgumentTypeMismatchException) {
      MethodArgumentTypeMismatchException e = (MethodArgumentTypeMismatchException)ex;
      // Do anything you want with it.
      // The method can be accessed using e.getParameter().getExecutable()
      log.error("Caught MethodArgumentTypeMismatchException method = {}",
          e.getParameter().getExecutable(), e);
    }
    return null;
  }
}