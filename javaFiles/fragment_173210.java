@Controller
public class UserController {

@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
public  @ResponseBody String getState(@RequestBody UserData ud) {
    System.out.println(ud.getPassword());
    return "true";
}

@RequestMapping(value = "/register", method = RequestMethod.POST)
public  @ResponseBody String registerUser(@RequestBody Users ud) {
    System.out.println(ud.getPassword());
    return "true";
}
}