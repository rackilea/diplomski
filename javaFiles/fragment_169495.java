@Controller
@RequestMapping("/user")
public class UserService {

  @RequestMapping(method = RequestMethod.POST, value="/login", headers="Accept=application/json")
  public @ResponseBody Response login(
        @RequestParam(value = "user", defaultValue = "") String email,
        @RequestParam(value = "password", defaultValue = "") String password,
        HttpServletRequest request
        ) {
    // Your logic here
  }
}