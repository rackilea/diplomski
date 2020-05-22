public interface Callable {
    public boolean call(Request request);
}

public class Handler {
    private Callable thisCallable;
    private Callable nextCallable;

    public Handler(Callable thisCallable, Callable nextCallable) {
        this.thisCallable = thisCallable;
        this.nextCallable = nextCallable;
    }

    public boolean handle(Request request) {
        return thisCallable.call(request) 
            || (nextCallable != null && nextCallable.call(request));
    }
}