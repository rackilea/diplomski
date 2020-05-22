@Controller
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/updateUserName", method = RequestMethod.POST)
  public StandardResponse updateUserName(HttpServletRequest request, HttpServletResponse reponses, Model model) {
    StandardResponse srObject = userService.updateUserName(request.getparameter("userId"),request.getParameter("userName"));
    return srObject;
  }
}