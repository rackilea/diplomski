public interface Job {
    void execute();
}

public class JobEnabledDecorator implements Job {
    private Job delegate;

    public JobEnabledDecorator(final Job delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute() {
        System.out.println("before");
        delegate.execute();
        System.out.println("after");
    }
}

public class MyJob implements Job {
    @Override
    public void execute() {
        System.out.println("execute");
    }
}