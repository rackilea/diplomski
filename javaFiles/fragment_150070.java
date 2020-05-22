@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}