@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)  
    public String test(@RequestParam("pars") String[] pars){}
}