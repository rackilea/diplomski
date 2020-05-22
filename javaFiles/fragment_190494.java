public class MyEventListener {

    @Autowired
    private SimpleMessageListenerContainer container;

    @EventListener
    public void someEvent(MyEvent event) {
        this.container.start();
    }

}