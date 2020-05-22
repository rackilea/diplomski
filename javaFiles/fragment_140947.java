class ExampleClass {
    static int staticField;
    static void staticMethod() {
        ExampleClass example = new ExampleClass();
        example.staticField;     // Equivalent to ExampleClass.staticField;
        example.staticMethod();  // Equivalent to ExampleClass.staticMethod();
    }
}