@Controller
public class HomeController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "home";
    }
}