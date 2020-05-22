@SpringBootApplication
public class MyJob {

    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NingesterApplication.class, args);
        // The batch job has finished by this point because the 
        //   ApplicationContext is not 'ready' until the job is finished
        // Also, use System.exit to force the Java process to finish with the exit code returned from the Spring App
        System.exit(SpringApplication.exit(context));
    }
}