@Component
public class ExecutorsStop implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    ExecutorsStart executorsStart;

    @Override
    public void onApplicationEvent(final ContextClosedEvent event) {
        System.out.println("Stopped: " + event);
    }
}