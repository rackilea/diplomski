@Stateless
public class AsyncEjb {

    @Resource
    private SessionContext sessionContext;

    @Asynchronous
    public Future<String> asyncMethod() {

        ...
        //Check if canceled by timer
        if(sessionContext.wasCancelCalled()) {
            ...
        }
        ...

    }
}

@Singleton
public class SingletonEjb {
    @EJB
    AsyncEjb asyncEjb;

    Future<String> theFuture;

    public void asyncMethod() {

        theFuture = asyncEjb.asyncMethod();

        //Create programatic timer
        long duration = 6000;
        Timer timer =
        timerService.createSingleActionTimer(duration, new TimerConfig());

    }

    //Method invoked when timer runs out
    @Timeout
    public void timeout(Timer timer) {
        theFuture.cancel(true);
    }
}