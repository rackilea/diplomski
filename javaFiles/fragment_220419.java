@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application .class, args);
    }
}

@Component
class Runner {

    @Autowired
    private Service service;

    @Scheduled(cron = "0 */2 * * * ?") // execute every 2 hours
    public void run() {
        // put your logic here
    }
}