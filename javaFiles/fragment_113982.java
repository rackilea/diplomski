public class Test {

    @PathParam("path")
    public Response doSomething() {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method method = Test.class.getMethod("doSomething");
        Annotation annotation = method.getAnnotations()[0];
        System.out.println(getValue(annotation));
    }

    private static String getValue(Annotation annotation) throws Exception {
        Class<?> type = annotation.annotationType();
        if (!ANNOTATIONS.contains(type)) {
            throw new IllegalArgumentException("...");
        }
        String value = (String) type.getMethod("value").invoke(annotation);
        return value;
    }

    private static final Set<Class<?>> ANNOTATIONS;

    static {
        Set<Class<?>> annotations = new HashSet<>();
        annotations.add(HeaderParam.class);
        annotations.add(QueryParam.class);
        annotations.add(PathParam.class);
        annotations.add(MatrixParam.class);
        annotations.add(CookieParam.class);
        annotations.add(FormParam.class);
        ANNOTATIONS = Collections.unmodifiableSet(annotations);
    }
}