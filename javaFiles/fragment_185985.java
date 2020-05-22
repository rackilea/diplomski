public class Foo {
    private final Clock clock;
    public Foo(Clock clock) {
        this.clock = clock;
    }

    public void someMethod() {
        Instant now = clock.instant();   // this is changed to make test easier
        System.out.println(now);   // Do something with 'now'
    }
}