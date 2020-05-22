@Controller
public class IndexController {

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    // this method is mapped to http://example.com/index
    public String handleRequest() {

        return "welcome"; // this will autoload the file welcome.jsp when the url is called
    }

}