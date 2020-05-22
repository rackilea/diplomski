public class Util {
 ...
 public static void method() {
    StackTraceElement[] st = Thread.currentThread().getStackTrace();
    //st[0] is the call of getStackTrace, st[1] is the call to Util.method, so the method before is st[2]
    System.out.println(st[2].getClassName() + "." + st[2].getMethodName());
 }
 ...
}