import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Bean {
    public String getMethod1(String a) {
        return a;
    }

    public String getMethod2(String a) {
        return a;
    }

    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Bean bean = new Bean();
        for (int i = 1; i <= 2; i++) {
            Method method = Bean.class.getMethod("getMethod" + i, String.class);
            System.out.println(method.invoke(bean, "Simple"));
        }

    }
}