@Startup
@Singleton
class MyEJB {
    @Resource
    private TimerService timerService = null;

    private Future<String> result;

    @EJB
    private Async asyncTask
    ...
    Timer timer = timerService.createTimer(timeout * 1000, timerId);

    @Timeout
    public void callTimeout(Timer timer){
        result = async.calculate();
    }
    public void cancel(){
        result.cancel();
    }
}

@Stateless
class Async {

    @Asynchronous
    public Future<String> calculate(){
        ...
        return new AsyncResult<String>(status);
    }
}