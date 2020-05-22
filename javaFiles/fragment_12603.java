@Autowired
private Executor someExecutor;


@Async
public Future<String> asyncService() {
    System.out.println();

    System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup());

    System.out.println();
    return CompletableFuture.supplyAsync(()->{

    System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup());
        return "hello";
    },someExecutor);

}