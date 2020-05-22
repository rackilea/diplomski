@ExceptionHandler(Exception.class)
 public ModelAndView handleAllException(Exception ex) {
  ModelAndView model = new ModelAndView("error_screen");
  model.addAttribute("error", "Exception happened");
  return model;
 }