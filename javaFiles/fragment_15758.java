import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    static class Base {};
    static class Child extends Base {
        public void setName(final String name) {
            System.out.println("setName("+name+")");
        }
    }


    public static void main(String[] args) {
        new Test().new_generic_report(Child.class, "Testname");
    }


    public void new_generic_report(final Class clazz, final String name) {
        Base base = createBase(clazz);

        try {
            Method m = clazz.getMethod("setName", String.class);
            m.invoke(base, name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Base createBase(Class report_class) {
        return new Child();
    }
}