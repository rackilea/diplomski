public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public Project load(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}