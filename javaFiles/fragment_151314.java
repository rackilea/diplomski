public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(TaskRepository taskService, ProjectRepository projectService) {
        Assert.notNull(taskService);
        Assert.notNull(projectService);

        this.taskRepository = taskService;
        this.projectRepository = projectService;
    }

    public Project load(Long projectId) {
        return projectRepository.findById(projectId);
    }
}