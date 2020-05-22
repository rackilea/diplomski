public class MyNonServletClass {
    public void method() {
        try {
            doSomething();
        } catch(Exception e) {
            myLogger.log(e);
        }
    }
}