@Controller
public class ExampleController {
    @RequestMapping(path = "/example", method = RequestMethod.GET, headers = "X-Custom")
    public String example() {
        return "example-view-name";
    }
}