@Controller
@RequestMapping(OneController.PATH)
public class OneController extends BaseController {

    protected static final String PATH = "/one";

    @Override
    public String getControllerPath(){
        return PATH;
    }
}