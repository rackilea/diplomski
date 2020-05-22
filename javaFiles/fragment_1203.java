@Controller
public class MyController {
    private int count = 0;
    @RequestMapping(value = "/index")
    public String respond() {
        count++;
        return "index";
    }
}