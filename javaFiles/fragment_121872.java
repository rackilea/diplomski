@Controller // Defines that this class is a spring bean
@RequestMapping("/users")
public class SomeController {

    // Tells the application context to inject an instance of UserService here
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public void login(@RequestParam("username") String username,
           @RequestParam("password") String password) {

        // The UserServiceImpl is already injected and you can use it
        userService.login(username, password);

    }
}