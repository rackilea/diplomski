public class Foo {
    private static String someName; // this is a class variable
    private String someOtherName; // this is an instance variable

    public Foo(String anotherName) { // anotherName is a constructor parameter
        int yetAnother = 1; // yetAnother is a local variable
        someOtherName = "foo"; // assign a value to someOtherName
    }