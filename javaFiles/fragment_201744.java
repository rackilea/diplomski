public @interface PageableDefault {
    int value() default 10;
    int size() default 10;
    int page() default 0;
    ...
}