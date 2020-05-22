@Controller
public class BaseController {

    // Map all urls to this method aside from ones starting with api
    @RequestMapping(value = "/**")
    public String getIndex() {
        // return the view called "index.html" (in the current directory)
        return "index";
    }

    @RequestMapping(value = "/api/**")
    @ResponseBody
    public String testApi() {
        return "test string";
    }
}