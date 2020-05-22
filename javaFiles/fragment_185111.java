@Controller
public class GameController{

    @RequestMapping(value="/createNewGame?parameter={param}",
                    method=RequestMethod.GET)
    public String createNewGame(@PathVariable String param, Model model) {
      // do stuff here
      return "viewName"; 
    }

}