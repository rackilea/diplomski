abstract class Foo<F extends Foo<F>> {
    abstract Processor<F> getProcessor();

    abstract F getThis();

    void processWith(Processor<F> p) {
        p.process(getThis());
    }
}