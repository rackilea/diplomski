@RestController
public class Controller {

    @RequestMapping("/")
    public SomeClass returnObjectInBrowser() {
        SomeClass someClass = new SomeClass();
        someClass.doStuff();

        return someClass;
    }
}