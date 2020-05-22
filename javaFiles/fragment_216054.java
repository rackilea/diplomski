public class SharedData {
    private static final MutexSem  mutex = new MutexSem();
    private static SharedData instance;
    private ClockValues clock;

    public static SharedData getInstance(ClockValues c) {
        mutex.take();
        if (instance == null) {
            instance = new SharedData(c);
        }
        mutex.give();
        return instance;
    }

    private SharedData(ClockValues c) {
        clock = c;
    }

    public void doSomething() { // NOTE: no longer static
        mutex.take();
        //do something with `clock`
        mutex.give();
    }

    //...
}