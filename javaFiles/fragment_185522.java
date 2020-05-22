public class InnerModule extends PrivateModule {
    private final Key<Foo> bindingKey;  // key will be exposed, bound to the @Inner Foo below

    @BindingAnnotation
    @Target({ FIELD, PARAMETER, METHOD })
    @Retention(RUNTIME)
    @interface Inner {
    }

    @Override
    protected void configure() {
        bind(bindingKey).to(Key.get(Foo.class, Inner.class));
        expose(bindingKey);
    }

    @Provides
    @Inner Foo getInnerFoo(...) {
        // Assume that the args are such that if they are "valid", we should return a FooB, else FooC
        if (...) return new FooB(...);
        else return new FooC(...);
    }
}