public abstract class A {

    protected static A INSTANCE;

    public static String getURL() {
        return INSTANCE.getURL();
    }

    protected abstract String getURL0();
}