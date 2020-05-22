@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) throws Exception {
        String companyName = servletContext.getInitParameter("companyName");
        mav.setViewName("home/index");
        mav.addObject("companyName", companyName);
        return mav;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}