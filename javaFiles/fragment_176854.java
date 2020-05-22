@Controller
public class Index {

    @RequestMapping("/index")
    public String show() {
        return "index"; //view 
    }

}