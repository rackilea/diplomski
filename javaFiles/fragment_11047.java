@Component
public class ContextClosedHandler implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    @Qualifier("executorService")
    private ExecutorService executor;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        executor.shutdown();
        try {
            // define how much time to wait for the completion
            if (!executor.awaitTermination(15, TimeUnit.MINUTES)) { 
                List<Runnable> incompleteTask = executor.shutdownNow();
                // do that you want with them
            }
        } catch (InterruptedException e) {
            // handle or log exception
        }
    }
}