@ManagedBean(eager=true)
@ApplicationScoped
public class TaskManager {

    private ExecutorService executor;

    @PostConstruct
    public void init() {
        executor = Executors.newSingleThreadExecutor();
    }

    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    // Or just void submit(Runnable task) if you want fire-and-forget.

    @PreDestroy
    public void destroy() {
        executor.shutdown();
    }

}