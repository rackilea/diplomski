public class AnnoTest {
    @Retention(RetentionPolicy.RUNTIME)
    @interface Email {}

    void example(@Email String arg) {}

    public static void main(String[] args) throws ReflectiveOperationException {
        Method method=AnnoTest.class.getDeclaredMethod("example", String.class);
        System.out.println("parameter type annotations:");
        AnnotatedType annotatedType = method.getAnnotatedParameterTypes()[0];
        //Annotation annotation = annotatedType.getAnnotation(Annotation.class);
        System.out.println(Arrays.toString(annotatedType.getAnnotations()));
        System.out.println("parameter annotations:");
        System.out.println(Arrays.toString(method.getParameterAnnotations()[0]));
    }
}