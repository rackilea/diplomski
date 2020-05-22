/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    Util util;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String home(Locale locale, Model model, String username, String password) {


        if(username.equalsIgnoreCase("david"))
        {
            model.addAttribute("validUser", "Welcome " + username );

            return "home";
        }
        else
        {
            model.addAttribute("validUser", "Incorrect username and password");
            return "home";
        }

    }

}