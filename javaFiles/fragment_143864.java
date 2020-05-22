public ModelAndView get() {

    // ...
    ModelAndView mav = new ModelAndView();
    List<String> options = Arrays.asList(getOptionsFromDatabaseAndConvertToStringList());
    mav.addObject("options",options );
    mav.setViewName("someview");

    return mav;
}