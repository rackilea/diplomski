@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @InitBinder("yourCommandObjectName")    // most probably "user"
    public void init(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    // handlers
}