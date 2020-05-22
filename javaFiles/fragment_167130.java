@RestController
//You can add this if you want or remove this class level mapping
@RequestMapping("/testApp")
public class TestController {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}