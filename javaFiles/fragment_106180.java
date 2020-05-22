@ExceptionHandler(SameEmailException.class) // UserNotFoundException.java
    public ModelAndView handleException(SameEmailException e) {
        ModelAndView modelAndView = new ModelAndView("errorView"); 
        modelAndView.addObject("errorMessage", e.getMessage());
        return modelAndView;
    }