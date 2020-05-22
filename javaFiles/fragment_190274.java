@Component

public class AppStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("On startup");
        /* task execution */

        // register DataCollector
        applicationReadyEvent
             .getApplicationContext()
             .getBeanFactory()
             .createBean(DataCollector.class);
    }
}


public class DataCollector {

    @Scheduled(fixedRate = 5000)
    public void executeTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // do sth
}