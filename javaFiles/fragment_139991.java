public class Globals {
    private static final Globals instance = new Globals();
    public static Globals get() { return instance; }

    public String value1 = "Hello"
    public int value2 = 42;
}