@Controller
@RequestMapping("/default")
public class DefaultController {
@RequestMapping(method=RequestMethod.GET)
    public String showDefault(){
        return "/static/default.html";
    }
}