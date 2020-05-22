public class Example {
    private static boolean staticField;
    private boolean instanceField;
    public static void main(String[] args) {
        // a static method can access static fields
        staticField = true;

        // a static method can access instance fields through an object reference
        Example instance = new Example();
        instance.instanceField = true;
    }