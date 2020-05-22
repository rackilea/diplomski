@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "/home";
    }
}