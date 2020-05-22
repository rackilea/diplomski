package newassertions;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

public class MyAssertions {

    public static void myAssertTrue(boolean b) {
        try {
            assertTrue(b);
        } catch (AssertionError e) {
            filterStackTrace(e);
            throw e;
        }
    }

    private static void filterStackTrace(AssertionError error) {
        StackTraceElement[] stackTrace = error.getStackTrace();
        if (null != stackTrace) {
            ArrayList<StackTraceElement> filteredStackTrace = new ArrayList<StackTraceElement>();
            for (StackTraceElement e : stackTrace) {
                if (!"newassertions.MyAssertions".equals(e.getClassName())) {
                    filteredStackTrace.add(e);
                }
            }
            error.setStackTrace(filteredStackTrace.toArray(new StackTraceElement[0]));
        }
    }
}