/** Marks Impl1 classes. Inject @Impl1 A to get A using C_Impl1 and D_Impl1. */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@interface Impl1 {}

/** Marks Impl2 classes. Inject @Impl2 A to get A using C_Impl2 and D_Impl2. */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@interface Impl2 {}

/** This is now a PrivateModule. Only exposed bindings can be used outside. */
public class Module1 extends PrivateModule {
    @Override
    protected void configure() {
        // Bind C and D as you had before.
        bind(C.class).to(C_Impl1.class);
        bind(D.class).to(D_Impl1.class);
        // Here's the tricky part: You're binding "@Impl1 A" to
        // "A" without a binding annotation, but only in here.
        bind(A.class).annotatedWith(Impl1.class).to(A.class);
        // Now you expose @Impl1 A, so it can be used outside.
        // As long as A, C, and D are only bound within private modules,
        // they won't conflict with one another, and @Impl1 A is unique.
        expose(A.class).annotatedWith(Impl1.class);
    }
}

/** Treat Module2 the same way, as a private module. */

public class Application {
    @Inject @Impl1 private final A someClassUsingImpl1;
    @Inject @Impl2 private final A someClassUsingImpl2;
    // ...
}