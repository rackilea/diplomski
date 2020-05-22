public abstract class MyEnum<E extends MyEnum<E>> {

    protected MyEnum(String name) {
        this.name = name;
    }

    private String name;

    protected String name() {
        return name;
    };

    @Override
    public final String toString() {
        return name().replace("_", " ");
    }
}

public final static class Example1 extends MyEnum<Example1> {
    public static final Example1 HELLO_WORLD = new Example1("HELLO_WORLD");

    protected Example1(String name) {
        super(name);
    }
}