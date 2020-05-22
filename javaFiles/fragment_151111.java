abstract class Foo<F extends Foo<F>> {
    abstract Processor<F> getProcessor();

    abstract F getThis();
}

class SomeFoo extends Foo<SomeFoo> {
    @Override
    SomeFoo getThis() {
        return this;
    }

    @Override
    Processor<SomeFoo> getProcessor() {
        return new SomeProcessor();
    }
}