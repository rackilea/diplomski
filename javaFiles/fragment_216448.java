@Controller
public class WebController {

@RequestMapping(value="/pages/Home.htm", method=RequestMethod.GET) 
public ModelMap buildHome(@RequestParam("foo", required=false) String foo){
return fillInHomePageData(foo);
}