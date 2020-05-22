private TaskScheduler scheduler;

Runnable exampleRunnable = new Runnable(){
    @Override
    public void run() {
        System.out.println("Works");
    }
};

@Async
public void executeTaskT() {
    ScheduledExecutorService localExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduler = new ConcurrentTaskScheduler(localExecutor);

    scheduler.schedule(exampleRunnable,
            new Date(1432152000000L));//today at 8 pm UTC - replace it with any timestamp in miliseconds to text
}

...

executeTaskT() //call it somewhere after the spring application has been configured