@SpringBootApplication
public class MyJob {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NingesterApplication.class, args);
        System.exit(SpringApplication.exit(context));
    }
}