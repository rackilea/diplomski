public interface DefaultMethods {

    public int getValue();

    public default int getValueIncremented() {
        if (UtilityMethod.helper()) { // never executed, just to demonstrate possibilities
            "string".charAt(0); // does nothing, just to show you can call instance methods
            return 0;
        }

        return 1 + getValue();
    }

    public static class UtilityMethod {

        public static boolean helper() {
            return false;
        }
    }
}