@Controller
public class IndexController {
    @Autowired
    private AppPortList apL; // Create this field with @Autowired annotation

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getdata() throws IOException {
        // Remove new AppPortList() and use field in stead
        List<AppPortModel> apList = apL.getAppPortList();   
        // ...
}