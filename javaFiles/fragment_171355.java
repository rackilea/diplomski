@Controller
@SessionAttributes("myObject")
public class SessionAttributesController {

    // Save session attribute in model. 
    @RequestMapping(value = "/page1.html", method = RequestMethod.GET)
    public String page1( @ModelAttribute MyClass myObject, ModelMap model ) {
        model.addtAttribute("myObject", myObject);
        return "page1.html";
    }

    // Now you model is having myObject, so it has to be used in jsp. You can add ModelMap parameter to this method and check what contains model in debug mode.   
    @RequestMapping(value = "/page2.html", method = RequestMethod.GET)
    public String page(ModelMap model) {
          model.get("myObject").setAttr10(value);   
          return "page2.html";
    }

}