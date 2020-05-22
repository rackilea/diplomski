@Controller
public class WelcomeController {

    @RequestMapping("/")
    public View welcomeUrl() {
        return new InternalResourceView("index.html");
    }
}