@Controller
public class VerverController
    private VerverDao ververDao;

    @Autowired
    public VerverController(VerverDao ververDao) {
        this.ververDao = ververDao;
    }
}