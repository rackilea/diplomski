import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class SimpleController {

    @GetMapping("/user")
    public String greeting(@RequestHeader(name = "userId") User user) {
        return "Hey, " + user.toString();
    }
}

public class User {
    private String id;
    private String firstName;
    private String lastName;
    ...
}