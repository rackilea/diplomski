@Controller
public class FooController {

    @RequestMapping(value="/foo/bar", method=RequestMethod.GET)
    public String fooAction(@LoggedUser User user) {
        System.out.print.println(user.getName());
        return "foo";
    }
}