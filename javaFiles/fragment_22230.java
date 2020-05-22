ModelAndView model;
if (some_condition) {
    model = new ModelAndView("admin");
}
else {
    model = new ModelAndView("admin2");
}
return model;