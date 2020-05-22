@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.POST)
    public String post(@ModelAttribute MyForm myForm) {
        System.out.println("@@@@@@: " + myForm.getDateTime());
        return "home";
    }
}