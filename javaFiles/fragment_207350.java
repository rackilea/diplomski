@Controller
public class UserController {

    private static Logger log = Logger.getAnonymousLogger();

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public String register(@RequestParam(value = "user") String username,
                           @RequestParam(value = "password") String password) {
        log.info(username + " " + password);
        return "true";
    }

}