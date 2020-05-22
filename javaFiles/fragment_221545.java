@SpringBootApplication
@EnableScheduling
public class SampleApp {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SampleApp.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        sender.sendMessage();
    }
}