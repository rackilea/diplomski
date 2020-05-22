public class FooFactory {

    public static Foo create(Class<Foo> clazz) {
        return clazz.newInstance();
    }

    public static Foo create(String className) {
        return create(Class.forName(className));
    }
}