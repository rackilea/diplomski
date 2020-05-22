protected ModelAndView onSubmit(HttpServletRequest request,
    HttpServletResponse response, Object command) throws Exception {

  ScheduleClass wiziqClass = (ScheduleClass) command;
  System.out.println(wiziqClass);
  return new ModelAndView("classdetail", "ScheduleClass", wiziqClass);
}