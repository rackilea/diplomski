import java.lang.reflect.Method;


public class ReflectionAccessTest {

    public final static void main(String[] args) throws Exception {
        for (int i = 0; i < 100000; i++) {
            // do some "training"
            ReflectionTarget.class.getMethod("a", Integer.TYPE, Integer.TYPE);
            ReflectionTarget.class.getMethod("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Integer.TYPE, Integer.TYPE);
            ReflectionTarget.class.getMethod("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Integer.TYPE, Integer.TYPE);
        }

        Method method = null;;
        long start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // do some "training"
            method = ReflectionTarget.class.getMethod("a", Integer.TYPE, Integer.TYPE);
        }
        System.out.println("Time to get method with short name " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            method.invoke(null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        System.out.println("Time to execute method with short name " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // do some "training"
            method = ReflectionTarget.class.getMethod("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Integer.TYPE, Integer.TYPE);
        }
        System.out.println("Time to get method with medium name " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            method.invoke(null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        System.out.println("Time to execute method with medium name " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            // do some "training"
            method = ReflectionTarget.class.getMethod("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Integer.TYPE, Integer.TYPE);
        }
        System.out.println("Time to get method with long name " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            method.invoke(null, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        System.out.println("Time to execute method with long name " + (System.currentTimeMillis() - start) + " ms");
    }

    private static class ReflectionTarget {
        public static void a(int a, int b) {
            // do nothing
        }

        public static void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(int a, int b) {
            // do nothing
        }

        public static void aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa(int a, int b) {
            // do nothing
        }
    }
}