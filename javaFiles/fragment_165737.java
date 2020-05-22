import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstTestController extends BaseController {
    @RequestMapping(path = "/something")
    public String sayHello() {
        return "Hello World !!";
    }

}