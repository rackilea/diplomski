@Controller
public class FooController() {

    @ModelAttribute("fooResults")
    public List<String> fooResults() {
        // return a list of string
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@ModelAttribute("command") Foo foo) {
        return "fooView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@ModelAttribute("command") Foo foo) {
        // do something with foo
    }