@Singleton
public class A {
    public void init() {}
}

@Singleton
public class B {
    public void init() {}
}

@Singleton
public class C {
    public void init() {}
}



@Startup
@Singleton
public class StartUpController {

    @Inject
    private A a;

    @Inject
    private B b;

    @Inject
    private C c;

    @PostConstruct
    protected void setup() {
        a.init();
        b.init();
        c.init();
    }

}