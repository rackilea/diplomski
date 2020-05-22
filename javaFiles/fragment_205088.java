@Controller
public class StudentController {
    ....
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String listStudents(Model model) {
        //your impl if is need
        return "index"; //or the view you want
    }
}