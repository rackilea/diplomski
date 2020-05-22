@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String logout(ModelMap model, HttpSession session) {
    //** do some thing **//
    return "redirect:/j_spring_security_logout";

}