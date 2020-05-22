interface Log {
    void logMessage();
}

public abstract class AbstractModule {
    protected Log log;

    public AbstractModule(){
        this.log = () -> {};
    }

    public AbstractModule(Log log){
        this.log = log;
    }

    public void doSomething() {        
        log.logMessage();        
        doStuff();
    }

    protected abstract void doStuff();
}