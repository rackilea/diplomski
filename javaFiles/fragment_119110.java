@Controller
public class YourController extends ConnectController {

    @Model
    private ModelMap model;

    @Override
    protected String connectView(){
        // model is here available
        model.addAttribute("attrName", "attrValue");
        return "connect/status";
    }

}