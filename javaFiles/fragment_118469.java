class Foo {
    public static final int FOO_VALUE = 1000;

    static {
        System.err.println("FOO Bar.BAR_VALUE=" + Bar.BAR_VALUE);
    }
}

class Bar extends Foo {
    public static final int BAR_VALUE = 2000;

    static {
        System.err.println("BAR Foo.FOO_VALUE=" + Foo.FOO_VALUE);
    }
}