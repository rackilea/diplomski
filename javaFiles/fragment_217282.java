@ExceptionHandler({Exception.class})
    public ModelAndView handleException(Exception ex) {
        ModelAndView model = new ModelAndView("Exception");

        model.addObject("exception", ex.getMessage());

        return model;
    }