@RestController
public class Test implements ErrorController {

    @RequestMapping("/connectToDb")
    public void doSomething() {
        ds = new Conn().dataSource(); // <<<<<
        System.out.println(ds);
    }
}