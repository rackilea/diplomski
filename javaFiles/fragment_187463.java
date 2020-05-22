@RequestMapping("/registerCompanyForm")
public ModelAndView registerCompanyForm(ModelMap modelMap){
    ModelAndView modelAndView=new ModelAndView();
    RegisterCmd registerCmd = new RegisterCmd();
    modelMap.addAttribute("registerCmd", registerCmd);
    modelAndView.addAllObjects(modelMap);
    modelAndView.setViewName("register");
    return modelAndView;
}