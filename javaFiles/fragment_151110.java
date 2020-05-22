interface Processor<F extends Foo<F>> {
    void process(F foo);
}

interface Foo<F extends Foo<F>> {
    Processor<F> getProcessor();
}

interface SomeFoo extends Foo<SomeFoo> {
    @Override
    SomeProcessor getProcessor();
}

interface SomeProcessor extends Processor<SomeFoo> {
    @Override
    void process(SomeFoo foo);
}