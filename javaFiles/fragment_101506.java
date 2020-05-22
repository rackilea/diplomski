@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static long count = 0;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskController tc;

    @Scheduled(fixedRate = 15000)
    public void createTasks() {

        count++;

        Task t = new Task();
        t.setTitle("Scheduled Task " + count);
        tc.create(t);
        taskRepository.saveAndFlush(t);

        log.info("A new scheduled task has been created!");
    }
}