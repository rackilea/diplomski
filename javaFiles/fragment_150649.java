public class ExampleClass {
    public static final int MAX_LENGTH = 100;
    private static ExampleEnum myEnum;

    private static void init(boolean condition) {
        if (condition) {
            myEnum = ExampleEnum.TRUE_CONDITION;
        } else {
            myEnum = ExampleEnum.FALSE_CONDITION;
        }
    }

    public static int getConstantValue() {
        return myEnum.getValue();
    }

}