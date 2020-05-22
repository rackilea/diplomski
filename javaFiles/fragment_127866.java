public class SO24278992 {

public static void main(String[] args) {

    Injector injector = Guice.createInjector(new AbstractModule() {

        @Override
        protected void configure() {
            // Different concrete instances of A and C
            // could be used here.  
            //
            // Alternatively, you don't need these explicit
            // bindings at all if the default contstructor
            // does everything you need and you are not 
            // requiring explicit bindings.

            bind(A.class).toInstance(new A());
            bind(C.class).toInstance(new C());

        }
    });

    B b = injector.getInstance(B.class);
    b.useA();
    b.useC();

}


static class B {

    private A classA;
    private C classC;

    @Inject
    public B(A a, C c) {
        this.classA = a;
        this.classC = c;
    }

    public void useC() {
        classC.doSomething();
    }

    public void useA() {
        classA.doSomethingElse();

    }
}


static class A {

    public void doSomethingElse() {
        System.out.println("Doing something else in A");
    }

}

static class C {

    public void doSomething() {
        System.out.println("Doing something in C");
    }

}
}