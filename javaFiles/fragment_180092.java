@ControllerAdvice
class NoHandlerFoundExceptionExceptionHandler {

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public ModelAndView
  defaultErrorHandler(HttpServletRequest req, NoHandlerFoundException e) throws Exception {
    String uri = // resolve the URI
    return new ModelAndView("redirect:" + uri);
  }
}