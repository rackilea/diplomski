@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private AdvDAO advDAO;

    @RequestMapping("/Advertisement")
    public ModelAndView listAdvs() {
        return new ModelAndView("index", "advs", advDAO.list());
    }