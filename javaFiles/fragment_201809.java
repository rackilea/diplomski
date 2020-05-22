import java.awt.Panel;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

class TestAnnotations {

    @Deprecated
    public Object getStuff() {
        return null;
    }

    public static void showAnnotations(
        Object obj,
        String methodName) throws Exception {

        Class cls = obj.getClass();
        Method m = cls.getMethod(methodName);
        System.out.println(m);
        Annotation[] as = m.getDeclaredAnnotations();
        for (Annotation a : as) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws Exception {
        Panel p = new Panel();
        showAnnotations(p, "show");

        TestAnnotations ta = new TestAnnotations();
        showAnnotations(ta, "getStuff");
    }
}