public class MyClass {

    public static int globallyVisibleInt = ...;

    // or

    private static int visibleThroughAccessors = ...;

    public static void messWithGlobalState(int newValue) {
        visibleThroughAccessors = newValue;
    }

    public static int seeGlobalState() {
        return visibleThroughAccessors;
    }

}