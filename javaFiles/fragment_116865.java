@Controller
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskServiceFactory taskServiceFactory;

    @PostMapping("/{taskId}/handle")
    public String handle(Model model, @PathVariable("taskId") Long taskId, HttpServletRequest request) throws Exception {
        try {
            TaskType type = TaskType.valueOf(request.getParameter("type"));
            Task task = taskServiceFactory.getService(type).handleTask(taskId, request);
            model.addAttribute("task", task);
        } catch (Exception e) {
            return "errorpage";
        }
        return "successpage";
    }
}