@Controller
@RequestMapping("/users")
public class UserController {

@RequestMapping(value = "", method = RequestMethod.GET)
 public ModelAndView get() {
    ModelAndView view = new ModelAndView("user");
    return view;
 }
}