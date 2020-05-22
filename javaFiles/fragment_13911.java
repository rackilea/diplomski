@Component
public class JmsStarter implements ApplicationRunner {
    private final JmsListenerEndpointRegistry jmsRegistry;

    public JmsStarter(JmsListenerEndpointRegistry jmsRegistry) {
        this.jmsRegistry = jmsRegistry;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (MessageListenerContainer listenerContainer : jmsRegistry.getListenerContainers()) {
            listenerContainer.start();
        }
    }
}