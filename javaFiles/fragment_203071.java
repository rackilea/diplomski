@RequestMapping(value = "/home")
public String doHome(ModelMap modelMap) {
   ...
}

@RequestMapping(value = "/**")
public String doDefault(ModelMap modelMap) {
   ...
}