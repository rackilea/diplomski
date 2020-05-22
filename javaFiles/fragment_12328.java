@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(Model model) {
        model.addAttribute("loginBean", new LoginBean());
        return "login";
    }

    @RequestMapping(value = "/showProfile", method = RequestMethod.POST)
    public String redirectToprofile(@ModelAttribute("loginBean") LoginBean loginBean , Model model) {
        StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
        Staff staff = staffServiceImpl.authenticateStaff(loginBean);
        if (null != staff) {
           model.addAttribute("staffData",staff);
           return "profilePage";
        }
        return "profileNotFound";
    }