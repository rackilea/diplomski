@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public String translate(@RequestParam String textForm, Model model) {
        // this will bind the request param to model
        model.addAttribute("textForm", textForm);

        return "success";
    }
}