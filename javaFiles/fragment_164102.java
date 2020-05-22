@SpringBootApplication
@EnableAsync
public class SendingEmailAsyncApplication {     
    public static void main(String[] args) {
        SpringApplication.run(SendingEmailAsyncApplication.class, args);
    }
}