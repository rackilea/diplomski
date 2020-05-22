@Controller
public class SomeController {

    @RequestMapping("/calendar")
    public String showCalendar(Model model) {
        Calendar calendar = getCalendar() // Or whatever you do to create it
        model.addAttribute("calendar", calendar);
        return "calendar";
    }

    ...
}