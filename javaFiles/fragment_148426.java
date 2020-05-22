@Component
public class MessagingApplicationListener implements ApplicationListener<ContextRefreshedEvent>, Notifiable {
    private final NotifierFactor notifierFactory;
    private final MessageSendingOperations<String> messagingTemplate;
    private Notifier notifier;

    @Autowired
    public MessagingApplicationListener(NotifierFactor notifierFactory, MessageSendingOperations<String> messagingTemplate) {
        this.notifierFactory = notifierFactory;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (notifier == null) {
            notifier = notifierFactory.create(this);
            notifier.start();
        }
    }

    public void notify(NotifyEvent event) {
        messagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, " + event.subject + "!"));
    }

    @PreDestroy
    private void stopNotifier() {
        if (notifier != null) {
            notifier.stop();
        }
    }
}