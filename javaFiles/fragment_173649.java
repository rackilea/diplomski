@RequestMapping(value = "helloReport4", method = RequestMethod.GET)
public ModelAndView getRpt4(ModelMap modelMap, ModelAndView modelAndView) {
  modelMap.put("datasource", getWidgets());
  modelMap.put("format", "pdf");
  modelAndView = new ModelAndView("rpt_HelloWorld", modelMap);
  return modelAndView;
}