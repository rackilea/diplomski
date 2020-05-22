@RestController
public class Test implements ErrorController {

    private final DataSource ds;
    private static final String PATH = "/error";

    public Test(DataSource ds) {
        this.ds = ds;
    }

    @RequestMapping("/connectToDb")
    public void doSomething() {
        System.out.println(ds);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}