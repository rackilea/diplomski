@Controller
@RequestMapping(value = "/grid")
public class GridController {
    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        // ...
    }

    @RequestMapping(value = "/{objType}", method = RequestMethod.GET)
    public String displayGrid(Model model, @PathVariable("objType") String objType) {
        // ...
    }

    @ResponseBody
    @RequestMapping(value = "/loadGrid", method = RequestMethod.GET)
    public String loadGrid(Model model) {
         // ...
    }
}