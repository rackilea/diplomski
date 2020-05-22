@Controller
@RequestMapping("/service")
public class NewController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String test(ModelMap model) {
        System.out.println(requestEntity.request.getAttribute("type")); // get it
        requestEntity.request.setAttribute("type", "Scope"); // set it so that we can make sure that our second request doesn't contain it
        System.out.println(requestEntity.request.getClass());
        return "whatever";
    }

    @Autowired
    private Foo requestEntity;
}