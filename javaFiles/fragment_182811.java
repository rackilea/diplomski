@SpringBootApplication
@EnableRetry
public class So40308025Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(So40308025Application.class, args);
        System.out.println(context.getBean(SpringRetryWithHystrixService.class).getStatus());
        context.close();
    }

}


@Component
public class SpringRetryWithHystrixService {

    public static int i = 0;

    @Retryable(maxAttempts = 5)
    public String getStatus() throws Exception {
        System.out.println("Attempt:" + i++);
        throw new NullPointerException();
    }

    @Recover
    public static String getRecoveryStatus() {
        return "Recovered from NullPointer Exception";
    }

}