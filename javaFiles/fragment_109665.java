public class ServiceOne {
    @Async
    public void bgTask() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ServiceTwo {
    @Autowired
    ServiceOne serviceOne;

    @Scheduled(fixedRate = 3000, initialDelay = 5000)
    public void scheduledRunner() {
        int i = 3;
        while (i-- >0 ) {
            serviceOne.bgTask();
        }
    }
}