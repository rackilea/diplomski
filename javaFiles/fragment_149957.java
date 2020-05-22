final Annotation[][] paramAnnotations = method.getParameterAnnotations();
final Class[] paramTypes = method.getParameterTypes();
for (int i = 0; i < paramAnnotations.length; i++) {
    for (Annotation a: paramAnnotations[i]) {
        if (a instanceof Foo) {
            System.out.println(String.format("parameter %d with type %s is annotated with @Foo", i, paramTypes[i]);
        }
    }
}