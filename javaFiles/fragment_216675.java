@Controller
public class MyController {

    @Autowired
    private CommonsMultipartResolver multipartResolver;


    @RequestMapping(value = "/setMaxUploadSize", method = RequestMethod.GET)
    public ModelAndView setMaxUploadSize() {
        ...
        multipartResolver.setMaxUploadSize(5000);
        ...
    }
}