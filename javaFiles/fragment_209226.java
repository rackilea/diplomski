@Controller("CustomCMSImageComponentController")
@RequestMapping(value = ControllerConstants.CustomCMSImageComponent )// now the controller is mapped to "/view/CustomCMSImageComponentController"
public class CustomCMSImageComponentController extends AbstractCMSComponentController<CustomCMSImageComponentModel> {
    @Override
    protected void fillModel(final HttpServletRequest request, final Model model,
                       final CustomCMSImageComponentModelcomponent) {
    //here the spring Model(model method parameter) should be filled with what is needed to dynamically render in JSP
    }
}