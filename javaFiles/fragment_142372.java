@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}