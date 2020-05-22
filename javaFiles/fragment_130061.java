@Controller
@RequestMapping("/default")
public class DefaultController {
    public String showDefault(){
        return "/static/default.html";
    }
}