@Controller
@RequestMapping("/test1")
public class Test1Controller {
    @RequestMapping("/new")
    public String newtest1() {
     //....
    }  
}

@Controller
@RequestMapping("/test2")
public class Test2Controller {
    @RequestMapping("/new")
    public String newtest2() {
     //....
    }  
}