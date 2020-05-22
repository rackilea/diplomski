@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }
}