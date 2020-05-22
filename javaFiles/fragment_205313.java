@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {
    boolean value() default false;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Type {
    Class<?> value();
}