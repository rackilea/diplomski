@ExceptionHandler(value = {DataIntegrityViolationException.class})
public ModelAndViewexceptionHandler(Exception ex, Locale locale) {
    String msg = ex.getMessage();
    // or if you have a I18n app : String msg = messageSource.getMessage("DUPKEY", null, locale);
    return new ModelAndView("duplicate", "msg", msg);
}