public class VariableContext {

    private static ThreadLocal<String> currentVariable = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "";
        }
    };

    public static void setCurrentVariable(String tenant) {
        currentVariable.set(tenant);
    }

    public static String getCurrentVariable() {
        return currentVariable.get();
    }

    public static void clear() {
        currentVariable.remove();
    }

}