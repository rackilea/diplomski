@Controller
public class PageController {
    @GetMapping
    public String persons(Model model) {
        model.addAttribute("util", this);
        return "persons";
    }

    public String url(String... params) {
        //evaluate...
        return "generatedurl";
    }
}