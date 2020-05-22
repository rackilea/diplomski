public class JacksonAnnotation {

    @Retention( RetentionPolicy.RUNTIME )
    @Target( ElementType.TYPE )
    public static @interface LogicModule {
        @JsonProperty
        String id();
        @JsonProperty
        int numberOfInputs();
    }

    @Retention( RetentionPolicy.RUNTIME )
    @Target( ElementType.TYPE )
    public static @interface LogicModule2 {
        String id();
        int numberOfInputs();
    }

    @LogicModule(id = "id", numberOfInputs = 123)
    public static class AnnotatedClass {

    }
    @LogicModule2(id = "id2", numberOfInputs = 321)
    public static class AnnotatedClass2 {

    }

    public static void main(String[] args) throws JsonProcessingException {
        List<LogicModule> modules = singletonList(AnnotatedClass.class.getAnnotation(LogicModule.class));
        List<LogicModule2> modules2 = singletonList(AnnotatedClass2.class.getAnnotation(LogicModule2.class));

        ObjectMapper mapper1 = new ObjectMapper();
        System.out.println(mapper1.writerWithDefaultPrettyPrinter().writeValueAsString(modules));

        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            @Override
            public PropertyName findNameForSerialization(Annotated a) {
                if (a instanceof AnnotatedMethod) {
                    Class<?> declaringClass = ((AnnotatedMethod) a).getMember().getDeclaringClass();
                    // checks that this is an annotation method
                    if (Annotation.class.isAssignableFrom(declaringClass)) {
                        try {
                            // exclude the other method defined in the super interface
                            Annotation.class.getMethod(a.getName());
                        } catch (NoSuchMethodException e) {
                            return new PropertyName(a.getName());
                        }
                    }
                }
                return super.findNameForSerialization(a);
            }
        });
        System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(modules2));
    }
}