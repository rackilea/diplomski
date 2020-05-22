@Provides
    @Exposed
    @Named("Inner") Foo getInnerFoo(...) {
        // Assume that the args are such that if they are "valid", we should return a FooB, else FooC
        if (...) return new FooB(...);
        else return new FooC(...);
    }