@Controller
public class TestController
{
    @RequestMapping(value = "/someview")
    public String showView()
    {
        return "index";
    }
}