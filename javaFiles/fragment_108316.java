import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Appcontroller {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home() {
        return "home";
    }
}