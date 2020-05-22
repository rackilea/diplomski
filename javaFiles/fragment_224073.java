@Controller
public class HelloController {


    @RequestMapping(value = "/jsonHelloEx", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity printWelcomeWithException() {
        String nullableString = null;
        nullableString.equals("");
        return ResponseEntity.ok("Hello");
    }
}