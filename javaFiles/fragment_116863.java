@Component
public class TaskServiceFactory {

    @Autowired
    private ManualTaskService manualTaskService;

    @Autowired
    private AutomatedTaskService automatedTaskService;

    public TaskService getService(TaskType type) throws Exception {
        switch (type) {
        case MANUAL_TASK:
            return manualTaskService;
        case AUTOMATED_TASK:
            return automatedTaskService;
        default:
            throw new Exception("Unrecognized task type");
        }
    }
}