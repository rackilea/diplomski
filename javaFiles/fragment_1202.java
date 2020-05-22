@Controller
public class MyController {
    @RequestMapping(value = "/index")
    public String respond() {
        return "index";
    }
}