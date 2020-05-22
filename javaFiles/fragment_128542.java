@Component
public class MainBean {

    @Autowired
    private MyTaskFactory myTaskFactory

    @Autowired
    private TaskScheduler taskScheduler


    public void start() {

        String str = "Print something to console";

        taskScheduler.execute(myTaskFactory.getTask(str));

    }
}


public class MyTaskFactory {

   public MyTask getTask(String str) {
       return new MyTask(str);
   }
}

@Configuration
public class MyTaskFactoryConfig {

   @Bean
   public MyTaskFactory myTaskFactory() {
      return new MyTaskFactory();
   }
}