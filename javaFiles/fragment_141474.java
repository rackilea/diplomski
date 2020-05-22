@RestController
@RequestMapping("/api")
public class Test {
    @GetMapping(value="/host")
    public String returnText() {
        return "hello";
    }
}