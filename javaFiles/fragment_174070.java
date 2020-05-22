public class Foo {

    private final Bar bar;

    @Inject
    public Foo(Bar bar) {
        this.bar = bar;
    }

    public void foo() {
        bar.bar();
    }
}

@Module(injects = MainActivity.class, library = true)
public class MainModule {

    @Provides
    @Singleton
    Bar provideBar() {
        return new Bar();
    }

    @Provides
    @Singleton
    Foo provideFoo(Bar bar) {
        return new Foo(bar);
    }

}