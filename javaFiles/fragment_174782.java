@Controller
public class TestController {

    @Autowired
    private Properties properties;

    @RequestMapping("/test")
    public String showMain(ModelMap model) {
        Integer ageMin = properties.getProperty("age.min");
        // .. DO YOUR PROCESSING
    }
}