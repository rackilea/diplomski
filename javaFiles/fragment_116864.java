@Service
public class ManualTaskServiceImpl implements ManualTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ManualTaskHandlerService manualTaskHandlerService;

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public Task handleTask(Long taskId) throws Exception {
        Task task = findById(taskId);
        manualTaskHandlerService.handleManualTask(task);
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}


@Service
public class AutomatedTaskServiceImpl implements AutomatedTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AutomatedTaskHandlerService automatedTaskHandlerService;

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public Task handleTask(Long taskId) throws Exception {
        Task task = findById(taskId);
        automatedTaskHandlerService.handleAutomatedTask(task);
        task.setCompleted(true);
        return taskRepository.save(task);
    }

}