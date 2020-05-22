class WorkState extends java.util.Observable {
    //A thread-safe observable java bean
}

class WorkTask implements Runnable {
    private final WorkState state = new WorkState();

    public void addStateObserver(Observer ob) {
         state.addObserver(ob);
    }

    @Override
    public void run() {
        //Task instructions here
        //instructions should operate on the state variable
    }
}

class VarMonitor implements Observer {
    private final ExecutorService eventQueue
            = Executors.newSingleThreadExecutor();

    @Override
    public void update(Observable subject, Object info) {
        //subject has changed, react to it
        eventQueue.submit(/* a Runnable that handles the state change,
                           with embedded information about the change */);

    }
}