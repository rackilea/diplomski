@Service
public class TaskAdministration {

    @Autowired
    private ApplicationContext appContext;

    private final TaskAdministrationRepository taskAdministrationRepository;

    public void commissionSystemTask(fields) {

        SystemTask task = new SystemTask(trigger);
        AutowireCapableBeanFactory factory = appContext.getAutowireCapableBeanFactory();
        factory.autowireBean( task );
        factory.initializeBean( task, "SystemTask" );

        taskScheduler.schedule(task, task.trigger);

        // persist task to restore if necessary
        taskAdministrationRepository.save(task);
    }
}