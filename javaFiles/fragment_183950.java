@Bar
public class Foo {
    public static void main(String[] args) {
        Annotation[] fooAnnotations = Foo.class.getAnnotations();
        assertEquals(1, fooAnnotations.length);
        for (Annotation annotation : fooAnnotations) {
            Annotation[] annotations =
                annotation.annotationType().getAnnotations();
            assertEquals(2, annotations.length);
            assertEquals(Baz.class, annotations[0].annotationType());
        }
    }

    @Baz
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Bar {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Baz {
    }
}