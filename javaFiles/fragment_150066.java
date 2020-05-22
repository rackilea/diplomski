public class Called {

public static void calledMethod() {
        System.out.println(Thread.currentThread().getStackTrace()[2].getClassName());
        // stackTrace 0 is get stack trace.
        // stack trace 1 is calledMethod
        // stack trace 2 is the calling method aka main in
    }
}