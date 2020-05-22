interface A {
}

interface B extends A {
}

abstract class C<T extends A> {
    protected abstract void abc(T xyz);
}

class D extends C<B> {
    @Override
    protected void abc(B xyz) {
        // Compiles
    }
}