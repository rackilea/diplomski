class Foo {
    public static final int FOO_VALUE = Integer.valueOf(1000).intValue();

    static {
        System.err.println("FOO " + Bar.BAR_VALUE);
    }
}

class Bar extends Foo {
    public static final int BAR_VALUE =  Integer.valueOf(2000).intValue();

    static {
        System.err.println("BAR " + Foo.FOO_VALUE);
    }
}