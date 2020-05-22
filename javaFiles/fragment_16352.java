public @interface InnerAnnotation {
    String value() default "hello";
}

public @interface OuterAnnotation {
    InnerAnnotation value() default @InnerAnnotation(value = "Goodbye");
}