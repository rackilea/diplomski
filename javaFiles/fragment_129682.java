package same.package.as.foo;

public class FooHelper {
    private final Foo foo;
    public FooHelper(Foo foo) {
        this.foo = foo;
    }

    public void stop() {
        this.foo.stop();
        this.foo.runningThread.interrupt();
    }
}