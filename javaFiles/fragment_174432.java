@Controller
@RequestMapping(value="/")
public class IndexController {

    @RequestMapping(value="")
    public String indexPage(Model model){

        return "index";
    }
}