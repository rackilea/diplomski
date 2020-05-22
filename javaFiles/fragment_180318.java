@Controller
public class LoginController {
...
@RequestMapping(value = "/login", method = RequestMethod.POST)
public ModelAndView login(@RequestParam(value = "tbusername") String username,
        @RequestParam(value = "tbpassword") String password,
        @ModelAttribute(value = "account") Account account,
        HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();
    account = accountSerivce.authenticate(username, password);
    //modelAndView.addObject("account", account);
    session.setAttribute("account", account);
    return new ModelAndView("index");
}
}