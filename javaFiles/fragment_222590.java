class Foo {
    public static enum fooState {
       young, adult, old;
    }

    public Foo(fooState i) {
        switch(i) {
        case young: ... break;
        case adult: ... break;
        case old: ... break;
        default: throw new InvalidStateException();
    }
    ...
}