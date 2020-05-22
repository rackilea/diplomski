@Controller
public class HomeController {

    @ModelAttribute("person")
    public Person getPerson(){
        return new Person();         
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value="/about", method=RequestMethod.POST)
    public void about(@ModelAttribute("person") Person person, BindingResult result, Model model)
    {
        if( ! result.hasErrors() ){
             // note I haven't compiled this code :)
        } 
    }   
 }