@RequestMapping("/report")
public ModelAndView report(HttpServletRequest request) {
    String environmentName = request.getParameter("name");
    ModelAndView model = new ModelAndView("report");    
    model.addObject("name", environmentName);

    return model;
}