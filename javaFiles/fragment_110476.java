@ComponentScan
@EnableAutoConfiguration
@Import(ScheduledTasks.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}