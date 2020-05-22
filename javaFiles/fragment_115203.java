public class InheritedAnnotationTest {

    @InheritedComponent
    public static class BaseComponent {
    }

    public static class SubClass extends BaseComponent {
    }

    public static void main(String[] args) {
        SubClass s = new SubClass();

        for (Annotation a : s.getClass().getAnnotations()) {
            System.out.printf("%s has annotation %s\n", s.getClass(), a);
        }
    }
}