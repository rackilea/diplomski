@RestController
public class ApiController {

    @AutoWired
    UserService userservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "<h1>Welcome to Spring REST API</h1>";
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserData> data() {
        return new userservice.getData();
    }

}