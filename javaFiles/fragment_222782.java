@Controller
// Model attribute with name "aopTeacherMaster" is transparently stored in the session
@SessionAttribute("aopTeacherMaster")
public class TeacherController {
    ...

    @RequestMapping(value = "/insertteacher2.html", method = RequestMethod.POST)
    public String testEm2(@Valid AopTeacherMaster teacher, BindingResult result, Map model) { 
        ...
        // No need to save teacher here
    }

    @RequestMapping(value = "/insertteacherLast.html", method = RequestMethod.POST)
    public String testEmLast(@Valid AopTeacherMaster teacher, BindingResult result, 
        Map model, SessionStatus status) { 
        ...
        // Save teacher at the last step
        teacher=schoolMasterService.add(teacher); 
        // Remove it from the session
        status.setComplete();
    }
}