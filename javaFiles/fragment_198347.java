@SpringBootApplication
public class So55263378Application {

    public static void main(String[] args) {
        SpringApplication.run(So55263378Application.class, args);
    }

    @RabbitListener(queues = "foo")
    public void listen(String in) {
        throw new OutOfMemoryError();
    }

    @EventListener
    public void listenForOOMs(ListenerContainerConsumerFailedEvent event) {
        System.out.println("Consumer thread died with " + event.getThrowable());
    }

}