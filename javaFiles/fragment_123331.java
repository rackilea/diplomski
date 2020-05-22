public class QuietFooAdapter implements Foo {

    private QuietFoo quietFoo;

    public QuietFooAdapter(QuietFoo quietFoo) {
        this.quietFoo = quietFoo;
    }

    public void bar() {
        quietFoo.bar();
    }
}