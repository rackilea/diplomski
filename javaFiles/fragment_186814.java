class Test {
    static int variable = 123;

    public static void main(String[] args) throws Exception {
        SomeGUI sg = new SomeGUI();
    }

    static class SomeGUI extends JFrame {

        public SomeGUI() throws Exception {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            // stackTrace[0] is getStackTrace(), stackTrace[1] is SomeGUI(),
            // stackTrace[2] is the point where our object is constructed.
            StackTraceElement callingStackTraceElement = stackTrace[2];
            String className = callingStackTraceElement.getClassName();
            Class<?> c = Class.forName(className);
            Field declaredField = c.getDeclaredField("variable");
            Object value = declaredField.get(null);
            System.out.println(String.format("test.variable = %d", value));
        }
    }
}