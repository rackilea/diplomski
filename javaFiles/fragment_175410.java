@ExceptionHandler(CustomGenericException.class)
public ModelAndView handleCustomException(CustomGenericException ex, HttpServletRequest request) {

  ModelAndView model2 = new ModelAndView("error/generic_error");
  model2.addObject("exception", ex);
  System.out.println(request.getAttribute("p"));
  System.out.println("CustomGenericException  ");
  return model2;

}