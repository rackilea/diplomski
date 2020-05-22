import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) {
        createArray(double.class);
    }

    private static void createArray(Class<?> clazz) {
        Object array = Array.newInstance(clazz, 4);
        System.out.println(array.getClass() == double[].class); // true
    }
}