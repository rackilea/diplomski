@Controller
public class TestController extends BaseController {

    @RequestMapping(value = "/rest/helloworld", method = RequestMethod.GET)
    public @ResponseBody
    String helloWorld(HttpServletRequest req)
            throws Exception {
        return "hello world";
    }
}