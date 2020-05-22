@SpringBootApplication
@EnableAsync
public class MainRunner implements AsyncConfigurer {

  private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MainRunner.class);

  @Override
  public Executor getAsyncExecutor() {
      return new SimpleAsyncTaskExecutor();
  }

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(MainRunner.class);
    MyService myService = (MyService) applicationContext.getBean("myService");
    LOGGER.info("Starting the submission of tasks...");
    for (int i = 1; i <= 50; i++)
    {
      myService.doSomething("Number" + i);
    }
    LOGGER.info("Finished submission of tasks...");
  }
}