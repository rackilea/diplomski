public class Foo {

    @Inject Instance<Object> instance;

    public void foo() {
        Bar bar = instance.select(Bar.class).get();
    }
}