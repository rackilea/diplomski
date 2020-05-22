public class LoggingDecorator implements ServiceObject {

    private final ServiceObject decoratee;

    public LoggingDecorator(ServiceObject decoratee) {
        this.decoratee = decoratee;
    }


    @Override
    public void execute(String operation, Map<?, ?> arguments) {
        MDC.set("context", myCtx);
        try {
            decoratee.execute(operation, arguments);
        } finally {
            MDC.remove("context");
        }
    }
}

public class SynchronizedDecorator implements ServiceObject {

    private final ServiceObject decoratee;

    private final Object lock = new Object();

    public SynchronizedDecorator(ServiceObject decoratee) {
        this.decoratee = decoratee;
    }

    @Override
    public void execute(String operation, Map<?, ?> arguments) {
        synchronized (lock) {
            decoratee.execute(operation, arguments);
        }
    }
}