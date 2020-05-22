// Local Code Package
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserOperations userOperations;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(SomeType instance){

        MyCustomObject custom = new MyCustomObject();
        userOperations.on(MyOperation.CREATE, instance, custom);

        return userService.create(instance);
    }

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public Object execute(SomeType instance){

        MyCustomObject custom = new MyCustomObject();
        userOperations.on("Execute", instance, custom);

        return userService.execute(instance);
    }
}