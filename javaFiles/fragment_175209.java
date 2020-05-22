import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ObjectHolder {
    public Object obj;

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        ObjectHolder oh1 = new ObjectHolder();
        oh1.obj = new int[] { 3, 4, 5 };

        ObjectHolder oh2 = new ObjectHolder();
        oh2.obj = new int[] { 3, 4, 6 };

        if (oh1.obj.getClass().isArray() && oh1.obj.getClass().equals(oh2.obj.getClass())) {
            Class<?> c = oh1.obj.getClass();

            if (!c.getComponentType().isPrimitive()) {
                c = Object[].class;
            }

            Method m = Arrays.class.getMethod("deepEquals", c, c);
            System.out.println((Boolean) m.invoke(null, oh1.obj, oh2.obj));
        }
    }
}