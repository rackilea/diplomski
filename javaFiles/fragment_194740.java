package ttyjni;

import java.io.Console;
import java.lang.reflect.Method;

class TestApp {
    static {
        System.loadLibrary("testapp");
    }
    private native boolean istty();

    private static final String ISTTY_METHOD = "istty";
    private static final String INTERACTIVE = "interactive";
    private static final String NON_INTERACTIVE = "non-interactive";

    protected static boolean isInteractive() {
        try {
            Method method = Console.class.getDeclaredMethod(ISTTY_METHOD);
            method.setAccessible(true);
            return (Boolean) method.invoke(Console.class);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return false;
    }

    public static void main(String[] args) {
        // Testing JNI
        TestApp t = new TestApp();
        boolean b = t.istty();
        System.out.format("%s(jni)\n", b ?
                "interactive" : "non-interactive");

        // Testing pure Java
        System.out.format("%s(console)\n", System.console() != null ?
                INTERACTIVE : NON_INTERACTIVE);
        System.out.format("%s(java)\n", isInteractive() ?
                INTERACTIVE : NON_INTERACTIVE);
    }
}