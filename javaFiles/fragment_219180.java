@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409 or according to your need any code
    @ExceptionHandler(Exception.class)
    protected ModelAndView unhandledExceptionHandler(Exception ex){
        System.out.println("handling exception here!!!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("errorView");
        mv.addObject("ERROR", "ERROR OCCURRED REDIRECTED "+ex.getMessage());
        return mv;
    }
}