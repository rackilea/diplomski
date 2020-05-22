@Controller
@RequestMapping("login")
public class LoginController 
{

    @RequestMapping(method = RequestMethod.GET)
    public String login(Authentication authentication)
    {
        if ((authentication != null) && authentication.isAuthenticated())
        {
            return "redirect:dashboard";
        }
        return "login";
    }

    @RequestMapping(value="doSomething", method = RequestMethod.POST)
    public String postLogin(Authentication authentication)
    {
        // Something else
    }

}