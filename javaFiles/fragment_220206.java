public static void main(String[] args) {
    Class<?> fooClass = Foo.class;
    AnnotatedType type = fooClass.getAnnotatedSuperclass();
    System.out.println(type);
    System.out.println(Bar.class == type.getType());
    System.out.println(Arrays.toString(type.getAnnotations()));
    System.out.println(Arrays.toString(type.getDeclaredAnnotations()));
}

public static class Bar {
}

public static class Foo extends @Custom Bar {
}

// So that annotation metadata is available at run time
@Retention(RetentionPolicy.RUNTIME)
// TYPE_USE being the important one
@Target(value = {ANNOTATION_TYPE, CONSTRUCTOR, FIELD, LOCAL_VARIABLE,
        METHOD, PACKAGE, PARAMETER, TYPE, TYPE_PARAMETER, TYPE_USE}) 
public @interface Custom {
}