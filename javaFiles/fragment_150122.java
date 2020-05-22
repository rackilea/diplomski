// application.properties
spring.mvc.view.prefix=/
spring.mvc.view.suffix=.html


// Controller for index.html
@Controller
public class IndexController {

    @RequestMapping({"/login", "/main/**"})
    public String index() {
        return "index";
    }
}