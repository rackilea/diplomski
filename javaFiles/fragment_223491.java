class Foo {
    protected int get_i() { return 0; }
}

public class Bar extends Foo {
    @Override
    protected int get_i() { return 1; }
}