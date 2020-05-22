@Controller
public class MultiLangController {

    @RequestMapping(value="/page", method = RequestMethod.GET)
    public String pageMethod() {        
        return ...;
    }    
}