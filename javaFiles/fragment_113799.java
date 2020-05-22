@Controller
@RequestMapping(value = "")
public class Controller

    @Autowired
    @Qualifier("accountDAO")
    private AbstractDAO accountDAO;

    .....
}