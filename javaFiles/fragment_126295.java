package foo.bar.test;

public class MyConfiguration {

    public static boolean shallExecute(final String className, final String methodName) {
        // your configuration logic
        System.out.println(className + "." + methodName);
        return false;
    }

}