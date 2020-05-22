@Configuration
@ComponentScan
public class TaskConfig {}

public interface TaskFactory {
    Task createTask();  
}

@Component
public class TaskFactoryImpl implements TaskFactory {

    private ApplicationContext parentContext;

    @Autowired
    public void setParentContext(ApplicationContext parentContext) {
        this.parentContext = parentContext;
    }

    @Override
    public Task createTask() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(TaskConfig.class);
            context.setParent(parentContext);
            context.refresh();
            return context.getBean(Task.class);
        }
    }
}