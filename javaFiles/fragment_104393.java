public class MyTask {

    private final long timeout;

    public MyTask(long timeout) {
        this.timeout = timeout;
    }

    @Scheduled(cron = "")
    public void cronTask() {
        Future<Object> result = doSomething();
        result.get(timeout, TimeUnit.MILLISECONDS);
    }

    @Async
    Future<Object> doSomething() {
        //what i should do
        //get ressources etc...
    }
}